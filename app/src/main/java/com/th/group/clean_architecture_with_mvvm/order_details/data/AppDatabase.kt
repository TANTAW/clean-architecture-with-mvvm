package com.th.group.clean_architecture_with_mvvm.order_details.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [OrderEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}

object DatabaseBuilder {
    private var INSTANCE: GfgDatabase? = null
    fun getInstance(context: Context): GfgDatabase {
        if (INSTANCE == null) {
            synchronized(GfgDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            GfgDatabase::class.java,
            "geeksforgeeks-example-coroutines"
        ).build()
}