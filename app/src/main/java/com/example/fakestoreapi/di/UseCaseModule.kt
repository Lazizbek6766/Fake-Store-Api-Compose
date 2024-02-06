package com.example.fakestoreapi.di

import com.example.fakestoreapi.domain.repository.CartRepository
import com.example.fakestoreapi.domain.repository.ProductsRepository
import com.example.fakestoreapi.domain.use_case.GetAllCategoryUseCase
import com.example.fakestoreapi.domain.use_case.GetAllProductsUseCase
import com.example.fakestoreapi.domain.use_case.GetProductUseCase
import com.example.fakestoreapi.domain.use_case.ProductsUseCases
import com.example.fakestoreapi.domain.use_case.cat_use_case.CartUseCases
import com.example.fakestoreapi.domain.use_case.cat_use_case.GetCartProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideProductsUseCases(repository: ProductsRepository):ProductsUseCases{
        return ProductsUseCases(
            getAllProductsUseCase = GetAllProductsUseCase(repository),
            getAllCategoryUseCase = GetAllCategoryUseCase(repository),
            getProductUseCase = GetProductUseCase(repository)
        )
    }
    
    @Provides
    @Singleton
    fun provideCartsUseCases(repository: CartRepository):CartUseCases{
        return CartUseCases(
            getCartProductsUseCase = GetCartProductsUseCase(repository)

        )
    }
}