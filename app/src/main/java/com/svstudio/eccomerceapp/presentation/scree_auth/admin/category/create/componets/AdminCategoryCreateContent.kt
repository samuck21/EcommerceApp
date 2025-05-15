package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminCategoryCreateContent(){
    Box(modifier = Modifier
        .background(color = Color.LightGray)
        .fillMaxSize()) {
        Image(
            painter = painterResource(id = com.svstudio.eccomerceapp.R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column() {
            Box(Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = com.svstudio.eccomerceapp.R.drawable.image_add),
                    contentDescription = ""
                )
            }
            Card(
                Modifier
                    .weight(2f)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(50.dp)

            ) {

                Column {
                    Text(
                        text = "CATEGORIA",
                        fontSize = 20.sp,
                        color = Color(0xFF00C8DF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 30.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "",
                            tint = Color(0xFF00C8DF),
                            modifier = Modifier.size(40.dp)
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("Nombre de la categoria") },
                            colors = TextFieldDefaults.colors(
                                disabledContainerColor = Color.White,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                            ),
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "",
                            tint = Color(0xFF00C8DF),
                            modifier = Modifier.size(40.dp)
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("Nombre de la categoria") },
                            colors = TextFieldDefaults.colors(
                                disabledContainerColor = Color.White,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                            ),
                        )
                    }


                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 40.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00C8DF)
                        )
                    ) {
                        Row {
                            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                            Text("Crear Categoria")
                        }

                    }

                }

            }
        }
    }
}