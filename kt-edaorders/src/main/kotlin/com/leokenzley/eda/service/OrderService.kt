package com.leokenzley.eda.service

import com.leokenzley.eda.model.OrderEvent

interface OrderService {
    fun processOrder(orderEvent: OrderEvent)
    fun saveHistory(orderEvent: OrderEvent)
}