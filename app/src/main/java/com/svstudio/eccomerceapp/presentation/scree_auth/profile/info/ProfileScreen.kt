package com.svstudio.eccomerceapp.presentation.scree_auth.profile.info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.info.componets.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController){
    Scaffold {
        ProfileContent(it,navController)
    }

}