package com.leokenzley.eda.database.mongodb.repository

import com.leokenzley.eda.model.OrderEvent
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface OrderEventRepository : MongoRepository<OrderEvent, String>{
}