package com.svstudio.eccomerceapp.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.AuthScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.LoginScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable( route = AuthScreen.Register.route) {
            RegisterScreen()
        }
    }
}