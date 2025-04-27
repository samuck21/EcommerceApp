package com.svstudio.eccomerceapp.presentation.componets

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text
    ){

    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 20.dp, end = 20.dp)){
        /*
         Image(painter = painterResource(id = com.svstudio.eccomerceapp.R.drawable.email),
             contentDescription = "IconEmail",
             modifier = Modifier.height(30.dp).width(30.dp)

         )*/
        Icon( imageVector = icon,
            contentDescription = "Email",
            modifier = Modifier.height(30.dp).width(30.dp),
            tint = Color(0xFFF4991A)
        )
        TextField(
            value = value,
            singleLine = true,
            label = {Text(text = label)},
            placeholder = {} ,
            onValueChange = { text ->
                onValueChange(text)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = modifier.padding(10.dp).fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color(0x00FFFFFF),
                focusedContainerColor = Color(0x00FFFFFF),
                unfocusedContainerColor = Color(0x00FFFFFF),
            )


        )
    }



}