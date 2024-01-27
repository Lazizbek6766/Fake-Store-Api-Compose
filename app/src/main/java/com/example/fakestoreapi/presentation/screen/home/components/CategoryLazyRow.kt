package com.example.fakestoreapi.presentation.screen.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryLazyRow(
    data: List<String>,
    selectedText: String,
    changeText: (String) -> Unit,
    isLoading: Boolean
) {
    LazyRow(content = {
        if (isLoading) {
            items(4) { item ->
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                        .width(100.dp)
                        .height(32.dp)
                        .shimmerBackground1(RoundedCornerShape(16.dp)),
                )
            }
        } else {
            itemsIndexed(data) { index, item ->
                if (item == selectedText) {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 4.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            contentColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.onBackground)
                                .padding(vertical = 4.dp, horizontal = 12.dp),
                            color = MaterialTheme.colorScheme.background,
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontWeight = FontWeight(400)

                            )
                        )
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 4.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            contentColor = MaterialTheme.colorScheme.onBackground
                        )
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .padding(vertical = 4.dp, horizontal = 12.dp)
                                .clickable { changeText(item) },
                            color = MaterialTheme.colorScheme.onBackground,
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontWeight = FontWeight(400)

                            )
                        )
                    }
                }
            }
        }

    })
}