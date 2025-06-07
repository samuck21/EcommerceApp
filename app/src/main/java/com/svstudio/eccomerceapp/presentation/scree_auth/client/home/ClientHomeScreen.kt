package com.svstudio.eccomerceapp.presentation.scree_auth.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.svstudio.eccomerceapp.presentation.navigation.graph.client.ClientNavGraph
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.componets.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { ClientBottomBar(navController) }


    ) { paddingValues ->
        ClientNavGraph(navController = navController)

    }
}