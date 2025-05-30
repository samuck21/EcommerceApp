package com.svstudio.eccomerceapp.presentation.scree_auth.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.svstudio.eccomerceapp.presentation.navigation.graph.admin.AdminNavGraph
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.componets.AdminBottomBar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold (
        bottomBar = {
            AdminBottomBar(navController = navController)
        }
    ) {  paddingValues ->
        AdminNavGraph(navController = navController)

    }
}