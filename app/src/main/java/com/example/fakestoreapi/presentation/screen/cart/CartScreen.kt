package com.example.fakestoreapi.presentation.screen.cart

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.domain.model.Rating
import com.example.fakestoreapi.presentation.screen.cart.components.CartLazyColumn

@Composable
fun CartScreen(){
    var items by remember { mutableStateOf<List<AllProductItem>>(
        listOf(
            AllProductItem(
                category = "",
                description = "",
                id = 0,
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                price = 0.0,
                rating = Rating(count = 0, rate = 0.0),
                title = "AAAAAA"
            ),
            AllProductItem(
                category = "",
                description = "",
                id = 0,
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                price = 0.0,
                rating = Rating(count = 0, rate = 0.0),
                title = "BBBBBB"
            ),
            AllProductItem(
                category = "",
                description = "",
                id = 0,
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                price = 0.0,
                rating = Rating(count = 0, rate = 0.0),
                title = "TTTTTT"
            ),
            AllProductItem(
                category = "",
                description = "",
                id = 0,
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                price = 0.0,
                rating = Rating(count = 0, rate = 0.0),
                title = "LLLLLL"
            ),
        )
    ) }
    Column {
        CartLazyColumn(
            data = items,
            isLoading = true
        )
    }
}