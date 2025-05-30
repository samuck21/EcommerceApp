package com.svstudio.eccomerceapp.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.auth.AuthScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.login.LoginScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable( route = AuthScreen.Register.route) {
            RegisterScreen(navController)
        }

    }
}