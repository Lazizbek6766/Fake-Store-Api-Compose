package com.example.fakestoreapi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fakestoreapi.data.db.model.ProductCart

@Database(entities = [ProductCart::class], version = 1,exportSchema = true)
abstract class CartDatabase : RoomDatabase() {
    abstract fun getProductBasketDao(): ProductCartDao

}