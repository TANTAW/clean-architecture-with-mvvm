package com.th.group.clean_architecture_with_mvvm.order_details.domain

import java.math.BigDecimal
import java.util.Date

data class Order(
    val id: String,
    val customerId: String,
    val orderDate: Date,
    val status: OrderStatus,
    val items: List<OrderItem>,
    val shippingAddress: Address,
    val paymentMethod: PaymentMethod,
    val totalAmount: BigDecimal,
    val tax: BigDecimal,
    val shippingCost: BigDecimal
)

data class OrderItem(
    val productId: String,
    val productName: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val subtotal: BigDecimal
)

enum class OrderStatus {
    PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String
)

data class PaymentMethod(
    val type: PaymentType,
    val lastFourDigits: String?,
    val expiryDate: Date?
)

enum class PaymentType {
    CREDIT_CARD, DEBIT_CARD, PAYPAL, BANK_TRANSFER
}