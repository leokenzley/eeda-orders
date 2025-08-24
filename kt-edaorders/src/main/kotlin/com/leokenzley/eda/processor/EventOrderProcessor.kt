package com.leokenzley.eda.processor

import com.leokenzley.eda.enumerates.StatusEnum
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.strategy.Strategy
import org.springframework.stereotype.Component

@Component
class EventOrderProcessor(
    private val strategies: List<Strategy>
) {
    private val strategyMap: Map<StatusEnum, Strategy> = strategies.associateBy { it.getStatus() }

    fun processEvent(orderEvent: OrderEvent) {

        do {
            val currentState = orderEvent.status
            var strategy = strategyMap[currentState]
                ?: throw IllegalStateException("No strategy found for state: $currentState")
            val nextStatus = strategy.nextStatus(orderEvent)
            if(strategy.nextStatus(orderEvent) == null) {
                break
            }else{
                val nextEvent = strategy.nextStatus(orderEvent)
                orderEvent.status = nextEvent!!
                orderEvent.history.add(nextEvent.name)
                strategy = strategyMap[nextEvent]
                    ?: throw IllegalStateException("No strategy found for state: $nextEvent")
            }
        }while (strategy.nextStatus(orderEvent) != null)
    }
}