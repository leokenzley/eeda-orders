package com.leokenzley.eda.model

import java.io.Serializable

data class Order(
    val orderId: String,
    val createdDate: String,
    val totalValue: Double,
    val products: Product,
    val paymentType: String
) : Serializable