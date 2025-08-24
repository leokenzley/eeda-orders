package com.leokenzley.eda.entrypoint.consumer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.Order
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.service.OrderService
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class CreateOrderConsumer(
    private val orderService: OrderService
) {
    private val logger = LoggerFactory.getLogger(CreateOrderConsumer::class.java)
    private val objectMapper = jacksonObjectMapper()


    @RabbitListener(queues = ["create-order"])
    fun consume(message: String) {
        logger.info("Mensagem recebida: $message")
        val order: Order = objectMapper.readValue(message)
        var orderEvent = OrderEvent(
            order = order,
            status = StatusEnum.CREATED,
            history = mutableListOf(StatusEnum.CREATED.name)
        )
        orderService.processOrder(orderEvent)
    }
}