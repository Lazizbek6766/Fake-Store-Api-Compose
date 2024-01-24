package com.example.fakestoreapi.presentation.screen.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryLazyRow(
    data: List<String>,
    selectedText: String,
    changeText: (String) -> Unit,
    isLoading:Boolean
) {
    LazyRow(content = {
        if(isLoading){
            items(4) { item ->
                if (item == 0) {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Text(
                            text = "",
                            modifier = Modifier
                                .shimmerBackground1(RoundedCornerShape(10.dp))
                                .background(Color.Black)
                                .width(100.dp)
                                .padding(vertical = 6.dp, horizontal = 8.dp),
                            color = Color.White
                        )
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Text(
                            text = "",
                            modifier = Modifier
                                .shimmerBackground1(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .width(100.dp)
                                .padding(vertical = 6.dp, horizontal = 8.dp),
                            color = Color.Black
                        )
                    }
                }
            }
        }else{
            itemsIndexed(data) { index, item ->
                if (item == selectedText) {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier
                                .background(Color.Black)
                                .padding(vertical = 4.dp, horizontal = 8.dp),
                            color = Color.White
                        )
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier
                                .background(Color.White)
                                .padding(vertical = 4.dp, horizontal = 8.dp)
                                .clickable { changeText(item) },
                            color = Color.Black
                        )
                    }
                }
            }
        }

    })
}