package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminCategoryScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListViewModel

@Composable
fun AdminProductListItem(navController: NavHostController, product: Product, vm: AdminProductListViewModel= hiltViewModel()){
    Column (modifier = Modifier.padding(top = 1.dp
    )){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(10.dp)
        ) {
            Column {
                Row(Modifier.padding(10.dp).fillMaxWidth()) {
                    Text("Fecha:",
                        Modifier.weight(6f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start )

                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .weight(1f)
                            .clickable{
                                navController.navigate(
                                    route = AdminCategoryScreen.ProductUpdate.passProduct(product.toJson())
                                )

                            },
                        tint = Color.Blue
                    )
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .weight(1f)
                            .clickable{
                              vm.deleteProduct(product.id ?:"")
                            },
                        tint = Color.Red
                    )
                }
                Divider(thickness = 2.dp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth())
                Row (modifier = Modifier.padding(10.dp)) {
                    Column(Modifier.weight(4f)) {
                        Text(text = product.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)
                        Text(text = product.description)
                        Text(text = product.price.toString(),fontSize = 15.sp)
                        Text("3 productos",fontSize = 15.sp)
                    }
                    AsyncImage( model = product.image1,
                        contentScale = ContentScale.Crop,
                        contentDescription = "",
                        modifier =
                            Modifier.size(height = 100.dp, width = 80.dp)
                                .weight(1f)
                    )

                }
            }
        }
    }

}