package com.example.fakestoreapi.di

import com.example.fakestoreapi.data.db.ProductCartDao
import com.example.fakestoreapi.data.remote.ApiService
import com.example.fakestoreapi.data.repository.CartRepositoryImpl
import com.example.fakestoreapi.data.repository.ProductsRepositoryImpl
import com.example.fakestoreapi.domain.repository.CartRepository
import com.example.fakestoreapi.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSocialRepository(apiService: ApiService): ProductsRepository {
        return ProductsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCartRepository(productCartDao: ProductCartDao): CartRepository {
        return CartRepositoryImpl(productCartDao)
    }
}