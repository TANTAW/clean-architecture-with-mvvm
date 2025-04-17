package com.th.group.clean_architecture_with_mvvm.order_details.domain

import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun getOrderDetails(id:Int): Flow<Order>
}
