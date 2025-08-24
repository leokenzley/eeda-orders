package com.leokenzley.eda.processor.strategy

import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import org.springframework.stereotype.Component

@Component
interface Strategy {
    fun nextStatus(orderEvent: OrderEvent): StatusEnum?
    fun getStatus(): StatusEnum
}