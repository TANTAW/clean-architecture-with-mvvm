package com.th.group.clean_architecture_with_mvvm.order_details.data

data class OrderDetailsResponse(
    val orderId: String,
    val userId: String,
    val orderDate: String, // ISO format
    val statusCode: Int,
    val items: List<OrderItemDto>,
    val shippingAddress: AddressDto,
    val paymentMethod: PaymentMethodDto,
    val subtotal: String,
    val tax: String,
    val shippingCost: String,
    val totalAmount: String
)

data class OrderItemDto(
    val productId: String,
    val name: String,
    val quantity: Int,
    val unitPrice: String,
    val subtotal: String
)

data class AddressDto(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String
)

data class PaymentMethodDto(
    val type: String,
    val lastFourDigits: String?,
    val expiryDate: String?
)
