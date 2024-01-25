package com.example.fakestoreapi.presentation.screen.product.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestoreapi.presentation.screen.home.components.shimmerBackground1

@Composable
fun ProductImage(
    imageUrl: String,
    modifier: Modifier
) {
    val context = LocalContext.current
    val imageRequest = remember {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .build()
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        AsyncImage(
            model = imageRequest,
            contentDescription = "productId",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}