package com.leokenzley.eda.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitProducerConfig {

    @Value("\${rabbitmq.consumer.kt-order.queue}")
    private lateinit var queue: String

    @Value("\${rabbitmq.consumer.kt-order.exchange}")
    private lateinit var exchange: String

    @Value("\${rabbitmq.consumer.kt-order.routing-key}")
    private lateinit var routingKey: String

    @Bean
    fun orderExchange(): DirectExchange =
        DirectExchange(exchange, false, false)

    @Bean
    fun createOrderProcessAgainQueue(): Queue =
        Queue(queue, false, false, false)

    @Bean
    fun bindingCreateOrderProcessAgain(
        createOrderProcessAgainQueue: Queue,
        orderExchange: DirectExchange
    ): Binding = BindingBuilder
        .bind(createOrderProcessAgainQueue)
        .to(orderExchange)
        .with(routingKey)
}