package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.svstudio.eccomerceapp.domain.model.Category
import android.graphics.fonts.Font
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment


import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun AdminCategoryListItem(category: Category) {
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Column(Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.weight(2f)) {

                        AsyncImage(
                            model = category.image,
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize(),

                            )
                        Text(
                            text = category.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "",
                            tint = Color.Blue,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(10.dp)
                                .size(30.dp)

                        )
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "",
                            tint = Color.Red,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(10.dp)
                                .size(30.dp)

                        )
                    }

                    Column(Modifier.weight(1.4f)) {

                        Text(
                            text = category.description,
                            fontWeight = FontWeight.Light,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }

                }
            }


        }
    }
}