package com.svstudio.eccomerceapp.presentation.scree_auth.profile.update

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.update.componets.ProfileUpdateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.update.componets.UpdateUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateScreen(navController: NavHostController,userParam: String) {
    Log.d("ProfileUpdateScreen","Data: $userParam")
    Scaffold (
     topBar = {
         TopAppBar(
             title = {
                 Text("Actualizar  perfil")
             },
             navigationIcon = {
                 IconButton(onClick = { navController.navigate(route = Graph.ADMIN) }) {
                     Icon( imageVector = Icons.Default.ArrowBack, contentDescription = "")
                 }
             },


         )
     }
    ) {
        ProfileUpdateContent(it,navController)
    }
    UpdateUser()

}