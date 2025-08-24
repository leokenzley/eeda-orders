package com.leokenzley.eda.processor.strategy.impl

import com.leokenzley.eda.adapter.producer.OrderProducer
import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.strategy.Strategy
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InvalidEventStrategy @Autowired constructor(
    private val orderProducer: OrderProducer
): Strategy {
    private final val serialVersionUID = 1L
    private final val status = StatusEnum.INVALID_EVENT
    private val logger = LoggerFactory.getLogger(InvalidEventStrategy::class.java)

    override fun getStatus(): StatusEnum {
        logger.info("Strategy InvalidEventStrategy")
        return status
    }

    override fun nextStatus(orderEvent: OrderEvent): StatusEnum? {
        logger.info("next: null")
        logger.info("send message to process again")
        orderProducer.sendOrderMessage(orderEvent.order)
        return null
    }
}