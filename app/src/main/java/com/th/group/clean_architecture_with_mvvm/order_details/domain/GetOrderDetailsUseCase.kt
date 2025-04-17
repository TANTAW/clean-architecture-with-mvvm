package com.th.group.clean_architecture_with_mvvm.order_details.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetOrderDetailsUseCase(private val repo: OrderRepository) {
    suspend operator fun invoke(orderId: Int): Flow<Result<Order>> {
        return repo.getOrderDetails(orderId)
            .map { order ->
                if (order.items.isEmpty()) {
                    throw Exception("Order has no items")
                }
                Result.success(order)
            }
            .catch { e -> emit(Result.failure(e)) }
    }
}