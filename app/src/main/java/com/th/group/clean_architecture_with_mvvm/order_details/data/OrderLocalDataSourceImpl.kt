package com.th.group.clean_architecture_with_mvvm.order_details.data

class OrderLocalDataSourceImpl(private val orderDao: OrderDao): OrderLocalDatasource {
    override suspend fun getOrderById(orderId: Int): OrderEntity? {
        return orderDao.getOrderWithDetais(orderId)
    }

    override suspend fun saveOrder(order: OrderEntity) {
        orderDao.inserOrderWithDetails(order)
    }

    override suspend fun orderExist(orderId: Int): Boolean {
        return orderDao.orderExists(orderId)
    }
}