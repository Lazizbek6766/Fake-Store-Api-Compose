package com.example.fakestoreapi.data.db

import androidx.room.*
import com.example.fakestoreapi.data.db.model.ProductCart
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductCartDao {
    @Query("SELECT * FROM product")
    suspend fun getCartProducts(): List<ProductCart>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(productCart: ProductCart)

    @Query("DELETE FROM product WHERE id =:id")
    suspend fun removeProductItem(id: Int)
}