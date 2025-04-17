package com.th.group.clean_architecture_with_mvvm.order_details.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@androidx.room.Dao
interface OrderDao {
    @Transaction
    @Query("SELECT * FROM orders WHERE id = :orderId")
    suspend fun getOrderWithDetails(orderId: Int): OrderEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: OrderEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderItems(items: List<OrderItemEntity>)
    
    @Transaction
    suspend fun insertOrderWithDetails(order: OrderEntity) {
        insertOrder(order.order)
        insertOrderItems(order.items)
        // Insert other related entities like shipping address, payment method
    }
    
    @Query("SELECT EXISTS(SELECT 1 FROM orders WHERE id = :orderId LIMIT 1)")
    suspend fun orderExists(orderId: Int): Boolean
}