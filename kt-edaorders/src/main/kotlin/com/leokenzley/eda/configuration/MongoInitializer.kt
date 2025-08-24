package com.leokenzley.eda.configuration

import org.springframework.boot.CommandLineRunner
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component

@Component
class MongoInitializer(
    private val mongoTemplate: MongoTemplate
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val dbName = "ordersdb"
        val collectionName = "orders"
        if (!mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.createCollection(collectionName)
        }
    }
}