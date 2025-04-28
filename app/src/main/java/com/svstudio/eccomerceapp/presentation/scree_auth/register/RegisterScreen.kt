package com.svstudio.eccomerceapp.presentation.scree_auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.R
import com.svstudio.eccomerceapp.presentation.componets.DefaultTextField

@Composable
fun RegisterScreen(viewModel: RegisterViewModel = hiltViewModel()){

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

        Box(modifier = Modifier.fillMaxWidth().weight(1f)){

            Image(painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo",
                Modifier.align(Alignment.Center)

            )
        }
        Card(modifier = Modifier.fillMaxWidth().weight(2f),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xC0FFFFFF)
            )

        ) {
            CardContent()

        }

    }
}
@Composable
fun CardContent(){
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var lastname by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }
    Column( horizontalAlignment = Alignment.CenterHorizontally) {
        Text("REGISTRARSE", textAlign = TextAlign.Start,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth().padding(top =  20.dp,start = 20.dp),
            fontWeight = FontWeight.Bold)
        DefaultTextField(
            modifier = Modifier,
            value = name,
            onValueChange = {name=it},
            label = "Nombres",
            icon = Icons.Filled.Person,
            keyboardType = KeyboardType.Unspecified
        )
        DefaultTextField(
            modifier = Modifier,
            value = lastname,
            onValueChange = {lastname=it},
            label = "Apellidos",
            icon = Icons.Filled.Person ,
            keyboardType = KeyboardType.Unspecified
        )
        DefaultTextField(
            modifier = Modifier,
            value = email,
            onValueChange = {email=it},
            label = "Correo",
            icon = Icons.Filled.Email,
            keyboardType = KeyboardType.Email
        )
        DefaultTextField(
            modifier = Modifier,
            value = phone,
            onValueChange = {phone=it},
            label = "Telefono",
            icon = Icons.Filled.Phone,
            keyboardType = KeyboardType.Phone
        )
        DefaultTextField(
            modifier = Modifier,
            value = password,
            onValueChange = {password=it},
            label = "Correo",
            icon = Icons.Filled.Lock,
            keyboardType = KeyboardType.Password
        )
        DefaultTextField(
            modifier = Modifier,
            value = passwordConfirm,
            onValueChange = {passwordConfirm=it},
            label = "Confirmar Contrasena",
            icon = Icons.Filled.Lock,
            keyboardType = KeyboardType.Password
        )

        Button(onClick = {},
            modifier= Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4991A)
            ),
            shape = RoundedCornerShape(10.dp),

            ) {
            Text("REGISTRARSE")
        }

    }

}
