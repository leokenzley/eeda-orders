package com.leokenzley.eda.adapter.producer

import com.leokenzley.eda.model.Order
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class OrderProducer(
    private val rabbitTemplate: RabbitTemplate
) {
    @Value("\${rabbitmq.consumer.kt-order.exchange}")
    private lateinit var exchange: String

    @Value("\${rabbitmq.consumer.kt-order.routing-key}")
    private lateinit var routingKey: String

    fun sendOrderMessage(message: Order) {
        rabbitTemplate.convertAndSend(
            exchange,
            routingKey,
            message
        )
    }
}