package com.leokenzley.eda.processor.strategy.impl

import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.strategy.Strategy
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class EndProccessingStrategy: Strategy {
    private final val serialVersionUID = 1L
    private final val status = StatusEnum.END_PROCESSING
    private val logger = LoggerFactory.getLogger(EndProccessingStrategy::class.java)
    override fun getStatus(): StatusEnum {
        logger.info("Strategy EndProccessingStrategy")
        return status
    }
    override fun nextStatus(orderEvent: OrderEvent): StatusEnum? {
        logger.info("Strategy null")
        return null
    }
}
