package com.example.fakestoreapi.presentation.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestoreapi.domain.model.AllProductItem

@Composable
fun ProductItem(
    item: AllProductItem,
    onItemClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 8.dp
            )
            .clickable { onItemClick(item.id) },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Card(
            modifier = Modifier
                .height(170.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            ),
            shape = RoundedCornerShape(10.dp)

        ) {
            AnimatedAsyncImage(
                imageUrl = item.image,
                modifier = Modifier,
            )
        }

        Text(
            text = item.title,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight(600)
            ),
            maxLines = 1,
            
        )
        Text(
            text = "${item.price} $",
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun AnimatedAsyncImage(imageUrl: String, modifier: Modifier) {

    val context = LocalContext.current
    val imageRequest = remember {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .build()
    }

    AsyncImage(
        model = imageRequest,
        contentDescription = "product",
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}