package com.svstudio.eccomerceapp.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.AuthScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.RolesScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.AdminHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.ClientHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.home.HomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.login.LoginScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){

        composable( route = RolesScreen.Roles.route) {
            RolesScreen(navController)
        }
        composable (route = Graph.CLIENT){
            ClientHomeScreen()
        }

    }
}