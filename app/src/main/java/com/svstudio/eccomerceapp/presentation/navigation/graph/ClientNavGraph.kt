package com.svstudio.eccomerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.AuthScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.ClientScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.AdminHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.ClientCategoryListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.ClientHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.ClientProductListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.home.HomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.login.LoginScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.ProfileScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.RolesScreen
@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
      navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ){
        composable (route = ClientScreen.ProductList.route) {
            ClientProductListScreen()
        }
        composable (route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen()
        }
        composable (route = ClientScreen.Profile.route) {
            ProfileScreen()
        }
    }
}