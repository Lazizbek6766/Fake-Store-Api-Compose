package com.example.fakestoreapi.presentation.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fakestoreapi.R
import com.example.fakestoreapi.presentation.component.CustomTopBar
import com.example.fakestoreapi.presentation.screen.home.components.shimmerBackground1
import com.example.fakestoreapi.presentation.screen.product.components.ProductImage
import com.example.fakestoreapi.presentation.screen.product.components.StarRatingBar

@Composable
fun ProductScreen(
    viewModel: ProductViewModel = viewModel()
){
    val viewState by viewModel.uiState.collectAsState()

    Scaffold (
        topBar = {
            CustomTopBar(
                text = "Product",
                navigationIcon = {
                    IconButton(onClick = {
//                        navigateToBack()
                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_left),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                })
        }
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            if (viewState.isLoading) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .shimmerBackground1(RoundedCornerShape(24.dp))
                )

            }else{
                ProductImage(
                    imageUrl = viewState.product!!.image,
                    modifier = Modifier
                )

                Row {

                    Column {
                        Text(
                            text = viewState.product!!.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        StarRatingBar(viewState.product!!.rating.rate.toFloat())
                    }

                }

                Text(
                    text = "Description",
                    style = TextStyle(
                        fontSize = 28.sp,
                        lineHeight = 36.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )

                Text(
                    text = viewState.product!!.description,
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    color = MaterialTheme.colorScheme.onBackground
                )

                Row(
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Card {
                        Row(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.onBackground)
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.shopping_cart),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.background
                            )
                            Text(
                                text = "Add to card",
                                color = MaterialTheme.colorScheme.background
                            )
                        }
                       
                    }
                }
            }
        }
    }
}