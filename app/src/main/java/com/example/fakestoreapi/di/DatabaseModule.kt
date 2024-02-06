package com.example.fakestoreapi.di

import android.content.Context
import androidx.room.Room
import com.example.fakestoreapi.data.db.CartDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun getCartDatabase(@ApplicationContext context: Context): CartDatabase =
        Room.databaseBuilder(context, CartDatabase::class.java, "basket").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun getProductBasketDao(database: CartDatabase) = database.getProductBasketDao()

}
