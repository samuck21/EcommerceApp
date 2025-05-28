package com.svstudio.eccomerceapp.presentation.scree_auth.roles.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.svstudio.eccomerceapp.domain.model.Rol
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.auth.AuthScreen

@Composable
fun RolesItem(rol: Rol, navController: NavHostController){
    ElevatedCard (
        elevation = CardDefaults
            .cardElevation(6.dp),
        modifier = Modifier.size(height = 250.dp, width = 180.dp)

    ){
        Column (modifier = Modifier.clickable{

            navController.navigate(route = rol.route){
                popUpTo(route = Graph.ROLES){inclusive = true}
            }
        }){

            AsyncImage(
                modifier = Modifier.fillMaxSize().weight(5f)
                    .width(150.dp),
                model = rol.image,
                contentDescription = "User",
                contentScale = ContentScale.Crop
            )
           // Spacer(modifier = Modifier.height(10.dp).weight(1f))
            Text( text =  rol.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).fillMaxWidth()
            )
        }
    }
    Spacer(modifier = Modifier.width(10.dp))


}