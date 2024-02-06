package com.example.fakestoreapi.presentation.screen.cart.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestoreapi.R
import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.presentation.component.DismissBackground
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartItem(
    item: AllProductItem,
    onRemove: (AllProductItem) -> Unit
) {
    val currentItem by rememberUpdatedState(item)
    var show by remember { mutableStateOf(true) }
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                show = false
                true
            } else false
        },
        positionalThreshold = { 150.dp.toPx() },
    )

    AnimatedVisibility(
        show, exit = fadeOut(spring())
    ) {
        SwipeToDismiss(
            state = dismissState,
            modifier = Modifier,
            background = {
                if (dismissState.dismissDirection == DismissDirection.EndToStart) {
                    DismissBackground(dismissState)
                }
            },
            dismissContent = {
                CardView(item)
            },
            directions = setOf(DismissDirection.EndToStart)
        )
    }
    LaunchedEffect(show) {
        if (!show) {
            delay(800)
            onRemove(currentItem)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardView(
    item: AllProductItem,
) {
    val context = LocalContext.current
    val imageRequest = remember {
        ImageRequest.Builder(context)
            .data(item.image)
            .crossfade(true)
            .build()
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(90.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),
            ) {
                AsyncImage(
                    model = imageRequest,
                    contentDescription = "card",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            CardText(item.title, item.price, modifier = Modifier.weight(1F))

            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(30.dp)
                    .width(60.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                ) {

                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_minus),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )

                    var text by remember { mutableStateOf("") }
                    TextField(
                        value = text,
                        modifier = Modifier
                            .background(Color.Transparent)
                            .weight(1F),
                        onValueChange = {text = it},
                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                    )
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )

                }
            }
        }
    }
}

@Composable
fun CardText(
    name: String,
    price: Double,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = name,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.weight(1F))
        Text(
            text = "$price $",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

}