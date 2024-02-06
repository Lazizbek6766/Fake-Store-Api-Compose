package com.example.fakestoreapi.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductCart(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val category: String,
    val description: String,
    val productId: Int,
    val image: String,
    val price: Double,
    val count: Int,
    val rate: Double,
    val title: String,
    val isService: Boolean = false
)