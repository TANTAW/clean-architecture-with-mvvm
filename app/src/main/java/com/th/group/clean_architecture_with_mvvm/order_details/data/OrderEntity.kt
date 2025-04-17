package com.th.group.clean_architecture_with_mvvm.order_details.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey val id: String,
    val customerId: String,
    val orderDate: Long, // Timestamp
    val status: Int,
    val totalAmount: Double,
    val tax: Double,
    val shippingCost: Double
)


@Entity(tableName = "order_items",
    foreignKeys = [ForeignKey(
        entity = OrderEntity::class,
        parentColumns = ["id"],
        childColumns = ["orderId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class OrderItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val orderId: String,
    val productId: String,
    val productName: String,
    val quantity: Int,
    val unitPrice: Double,
    val subtotal: Double
)

@Entity(tableName = "shipping_addresses")
data class ShippingAddressEntity(
    @PrimaryKey val orderId: String,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String
)

@Entity(tableName = "payment_methods")
data class PaymentMethodEntity(
    @PrimaryKey val orderId: String,
    val type: Int,
    val lastFourDigits: String?,
    val expiryMonth: Int?,
    val expiryYear: Int?
)