package com.leokenzley.eda.model

import com.leokenzley.eda.enumerates.StatusEnum
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable
import java.time.Instant
import java.time.OffsetDateTime
import java.util.UUID

@Document(collection = "orders")
data class OrderEvent(
    val id: String = UUID.randomUUID().toString(),
    val order: Order,
    var createdDate: Instant = Instant.now(),
    var status: StatusEnum,
    var history: MutableList<String> = mutableListOf()
): Serializable
