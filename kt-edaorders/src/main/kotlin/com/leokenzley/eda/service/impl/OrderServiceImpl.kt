package com.leokenzley.eda.service.impl

import com.leokenzley.eda.database.mongodb.repository.OrderEventRepository
import com.leokenzley.eda.model.OrderEvent
import com.leokenzley.eda.processor.EventOrderProcessor
import com.leokenzley.eda.service.OrderService
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private final val processor: EventOrderProcessor,
    private final val orderEventRepository: OrderEventRepository
): OrderService {
    override fun processOrder(orderEvent: OrderEvent) {
        processor.processEvent(orderEvent)
        saveHistory(orderEvent)
    }

    override fun saveHistory(orderEvent: OrderEvent) {
        orderEventRepository.save<OrderEvent>(orderEvent)
    }
}