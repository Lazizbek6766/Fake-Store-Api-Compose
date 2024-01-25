package com.example.fakestoreapi.presentation.screen.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fakestoreapi.R
import com.example.fakestoreapi.presentation.component.CustomTopBar
import com.example.fakestoreapi.presentation.screen.home.components.shimmerBackground1
import com.example.fakestoreapi.presentation.screen.product.components.ProductImage

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
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_left),
                            contentDescription = null
                        )
                    }
                })
        }
    ){
        Column(
            modifier = Modifier.padding(it)
        ) {
            if (viewState.isLoading) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(horizontal = 20.dp)
                    .shimmerBackground1(RoundedCornerShape(24.dp))
                )
            }else{
                ProductImage(
                    imageUrl = viewState.product!!.image,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

        }
    }
}