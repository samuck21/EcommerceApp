package com.svstudio.eccomerceapp.presentation.scree_auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.R
import com.svstudio.eccomerceapp.presentation.componets.DefaultTextField
import com.svstudio.eccomerceapp.presentation.navigation.screen.AuthScreen

@Composable

fun LoginScreen(navController: NavHostController){
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Image(painter = painterResource(id = R.drawable.banner),
        contentDescription = "Background",
        Modifier.fillMaxSize(), contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.colorMatrix(
            ColorMatrix().apply {
                setToScale(0.5f,0.5f,0.5f,1f)
            }
        )
    )

    Column {

        Box(modifier = Modifier.fillMaxWidth().weight(2f)){

            Image(painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo",
                Modifier.align(Alignment.Center)

            )
        }
        Card(modifier = Modifier.fillMaxWidth().weight(1f),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xC0FFFFFF)
            )

        ) {
           Column( horizontalAlignment = Alignment.CenterHorizontally) {
               Text("INGRESAR", textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                   modifier = Modifier.fillMaxWidth().padding(top =  20.dp,start = 20.dp),
                   fontWeight = FontWeight.Bold)

               DefaultTextField(
                   modifier = Modifier,
                   value = email,
                   onValueChange = {email=it},
                   label = "Correo electronico",
                   icon = Icons.Filled.Email,
                   keyboardType = KeyboardType.Email
               )
               DefaultTextField(
                   modifier = Modifier,
                   value = password,
                   onValueChange = {password=it},
                   label = "Contrasena",
                   icon = Icons.Filled.Email,
                   keyboardType = KeyboardType.Password
               )
               Button(onClick = {},
                   modifier= Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = Color(0xFFF4991A)
                   ),
                   shape = RoundedCornerShape(10.dp),

               ) {
                   Text("LOGIN")
               }
               Box(){
                   Row {
                       Text("No tienes cuenta?")
                       Text("Registarte",
                           fontStyle = FontStyle.Italic ,
                           fontFamily = FontFamily.SansSerif,
                           modifier = Modifier.padding( start = 10.dp).clickable{
                           navController.navigate(route = AuthScreen.Register.route)
                           },
                           color = Color(0xFFF4991A)
                           )
                   }
               }

           }

        }

    }
}