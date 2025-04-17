package com.th.group.clean_architecture_with_mvvm.order_details.data

import com.th.group.clean_architecture_with_mvvm.order_details.domain.Order
import com.th.group.clean_architecture_with_mvvm.order_details.domain.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrderDetailsRepoImpl(
    private val remoteDatasource: OrderRemoteDataSource,
    private val localDatasource: OrderLocalDatasource,
    private val orderMapper: OrderMapper,
) :
    OrderRepository {
    override suspend fun getOrderDetails(id: Int): Flow<Order> = flow {
        // Try to get Local order
        localDatasource.getOrderById(id)?.let { localOrder ->
            emit(orderMapper.mapEntityToDomain(localOrder))
        }
    }
}