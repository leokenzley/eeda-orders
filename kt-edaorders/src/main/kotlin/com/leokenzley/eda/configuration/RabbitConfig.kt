package com.leokenzley.eda.configuration

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    @Bean
    fun rabbitListenerContainerFactory(connectionFactory: ConnectionFactory): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)
        // Aqui você define o nome fixo do consumer
        factory.setConsumerTagStrategy { queue -> "kt-consumer" }
        return factory
    }

    @Bean
    fun messageConverter() = Jackson2JsonMessageConverter()
}