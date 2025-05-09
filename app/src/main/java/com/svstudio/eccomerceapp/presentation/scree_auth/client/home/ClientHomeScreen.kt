package com.svstudio.eccomerceapp.presentation.scree_auth.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.svstudio.eccomerceapp.presentation.navigation.graph.ClientNavGraph
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.componets.ClientBottomBar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold (
        bottomBar = { ClientBottomBar(navController) }
    ) {  paddingValues ->
        ClientNavGraph(navController = navController)

    }
}