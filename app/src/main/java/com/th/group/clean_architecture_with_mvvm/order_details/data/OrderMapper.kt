package com.th.group.clean_architecture_with_mvvm.order_details.data

import com.th.group.clean_architecture_with_mvvm.order_details.domain.Order

class OrderMapper {
    fun mapEntityToDomain(
        orderEntity: OrderEntity,
        items: List<OrderItemEntity>,
        address: ShippingAddressEntity,
        paymentMethod: PaymentMethodEntity
    ): Order {
        // Conversion logic from entities to domain model
    }
    
    fun mapDomainToEntity(order: Order): OrderEntity {
        // Conversion logic from domain to entity
    }
    
    fun mapResponseToDomain(response: OrderDetailsResponse): Order {
        // Conversion logic from API response to domain
    }
}