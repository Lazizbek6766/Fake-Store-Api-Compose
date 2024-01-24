package com.example.fakestoreapi.di

import com.example.fakestoreapi.SharedPref
import com.example.fakestoreapi.data.remote.ApiService
import com.example.fakestoreapi.utills.Constants.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
        .build()

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun getClient(sharedPref: SharedPref): OkHttpClient = with(
        OkHttpClient.Builder()
    ) {
        connectTimeout(60, TimeUnit.SECONDS)
        writeTimeout(60, TimeUnit.SECONDS)
        readTimeout(60, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })

        addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()

            if (sharedPref.token != "") {
                builder.header("Authorization", "Token ${sharedPref.token}")
            }

            builder.header("Accept", "application/json")
            chain.proceed(builder.build())
        }).build()
    }

}