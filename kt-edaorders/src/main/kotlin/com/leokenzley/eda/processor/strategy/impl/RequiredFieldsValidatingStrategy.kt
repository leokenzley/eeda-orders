package com.leokenzley.eda.processor.strategy.impl

import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.strategy.Strategy
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RequiredFieldsValidatingStrategy: Strategy {
    private final val serialVersionUID = 1L
    private final val status = StatusEnum.REQUIRED_FIELDS_VALIDATING
    private val logger = LoggerFactory.getLogger(RequiredFieldsValidatingStrategy::class.java)

    override fun getStatus(): StatusEnum {
        logger.info("Strategy RequiredFieldsValidatingStrategy")
        return status
    }

    override fun nextStatus(orderEvent: OrderEvent): StatusEnum? {
        if(orderEvent.order.totalValue == null || orderEvent.order.totalValue == 0.0)
            return StatusEnum.INVALID_EVENT

        logger.info("next: SEND_MAIL")
        return StatusEnum.SEND_MAIL
    }
}