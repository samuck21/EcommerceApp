package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.svstudio.eccomerceapp.presentation.componets.DotsIndicator
import com.svstudio.eccomerceapp.presentation.componets.SliderView
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail.ClientProductDetailViewModel
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@Composable

fun ClientProductDetailContent(paddingValues: PaddingValues,vm: ClientProductDetailViewModel = hiltViewModel()){
    val state = rememberPagerState(pageCount = { 10 })

    val pagerState = rememberPagerState(pageCount = {
        vm.productImage.size
    })
    Box(Modifier.padding(paddingValues)){
        Column() {
            HorizontalPager (state = pagerState) { page ->
                Card(
                    Modifier
                        .height(320.dp)
                        .fillMaxWidth()
                        .graphicsLayer {
                            // Calculte the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            // We animate the alpha, between 50% and 100%
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    AsyncImage(
                        model = vm.productImage[page],
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop

                    )




                }
            }
        }
        Column(){
            Box(Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center){

            }
            Card(Modifier
                .weight(2f)
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(50.dp)

            ) {

                Column {
                   Text(
                        text = vm.product.name,
                        fontSize = 20.sp,
                        color = Color(0xFF00C8DF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 30.dp)
                    )
                    Text(
                        text = "Descripcion",
                        fontSize = 20.sp,
                        color = Color(0xFF00C8DF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 30.dp)
                    )
                    Text(
                        text = vm.product.description,
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 10.dp)
                    )
                    androidx.compose.material3.Text(
                        text = "Precio",
                        fontSize = 20.sp,
                        color = Color(0xFF00C8DF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 30.dp)
                    )
                    Text(
                        text = vm.price.toString(),
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 10.dp)
                    )
                    Text(
                        text = "Cantidad",
                        fontSize = 20.sp,
                        color = Color(0xFF00C8DF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 30.dp)
                    )
                    Text(
                        text = "Cantidad:${vm.quantity}",
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 10.dp)
                    )
                    Text(
                        text = "Cantidad:${vm.price}",
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth().padding(20.dp, top = 10.dp)
                    )



                    Row( modifier = Modifier.padding(20.dp)) {
                        Box(modifier = Modifier
                            .background(Color(0xff000000))
                            .height(40.dp)
                            .weight(1f),




                            ){
                            Row(modifier = Modifier.fillMaxSize().padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically) {
                                androidx.compose.material3.Text(
                                    "-",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable{
                                            vm.remove()
                                        }
                                    ,
                                    color = Color.White
                                )
                                Text(
                                    text = vm.quantity.toString(),
                                    modifier = Modifier.weight(1f),
                                    color = Color.White
                                )


                                Text(
                                    "+",
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable{
                                           vm.add()
                                        },
                                    color = Color.White
                                )
                            }
                        }
                        Button(onClick = {
                            vm.saveItem()

                        }, modifier = Modifier
                            .height(40.dp)
                            .weight(2f)
                            .padding(start = 10.dp)
                            , shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF00C8DF)
                            )

                        ) {
                            Row {
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                                androidx.compose.material3.Text("Crear Categoria")
                            }

                        }
                    }




                }




            }

        }
    }

    LaunchedEffect(
        key1 = state.currentPage
    ) {
        delay(3000)
        var newPosition = state.currentPage +1
        if(newPosition>vm.productImage.size -1){
            newPosition= 0
        }
        state.animateScrollToPage(newPosition)
    }
}