package com.leokenzley.eda.processor.strategy.impl

import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.strategy.Strategy
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SendMailStrategy: Strategy {
    private final val serialVersionUID = 1L
    private final val status = StatusEnum.SEND_MAIL
    private val logger = LoggerFactory.getLogger(RequiredFieldsValidatingStrategy::class.java)

    override fun getStatus(): StatusEnum {
        logger.info("Strategy SendMailStrategy")
        return status
    }

    override fun nextStatus(orderEvent: OrderEvent): StatusEnum? {
        logger.info("Strategy END_PROCESSING")
        return StatusEnum.END_PROCESSING
    }
}
