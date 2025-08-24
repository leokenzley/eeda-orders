package com.leokenzley.eda.processor.strategy.impl

import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.strategy.Strategy
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CreatedStrategy: Strategy {
    private val logger = LoggerFactory.getLogger(CreatedStrategy::class.java)
    private final val serialVersionUID = 1L
    private final val status = StatusEnum.CREATED
    override fun getStatus(): StatusEnum {
        logger.info("Strategy CreatedStrategy")
        return status
    }

    override fun nextStatus(orderEvent: OrderEvent): StatusEnum? {
        logger.info("next: REQUIRED_FIELDS_VALIDATING")
        return StatusEnum.REQUIRED_FIELDS_VALIDATING
    }
}
