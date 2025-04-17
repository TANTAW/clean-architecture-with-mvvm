package com.th.group.clean_architecture_with_mvvm.order_details.data

interface OrderLocalDatasource {
    suspend fun getOrderById(orderId:Int): OrderEntity?
    suspend fun saveOrder(order: OrderEntity)
    suspend fun orderExist(orderId: Int): Boolean
}
