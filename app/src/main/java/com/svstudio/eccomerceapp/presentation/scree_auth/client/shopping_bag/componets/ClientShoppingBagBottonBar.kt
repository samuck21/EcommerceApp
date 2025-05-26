package com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ShoppingBagScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.ClientShoppingBagViewModel

@Composable
fun ClientShoppingBagBottonBar(navController: NavHostController,vm: ClientShoppingBagViewModel = hiltViewModel()) {
    Row(
    modifier = Modifier
    .fillMaxWidth()
    .background(color = Color.LightGray),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            modifier = Modifier.run { padding(vertical = 15.dp) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hola")
            Text(
                text = "TOTAL",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = vm.total.toString() + "$",
                fontSize = 16.sp
            )
        }

        Button(
            modifier = Modifier
                .padding(vertical = 15.dp),
            onClick = { navController.navigate(route = ShoppingBagScreen.AddressList.route) }
        ){
            Text( text = "Confirmar orden")
        }
    }
}