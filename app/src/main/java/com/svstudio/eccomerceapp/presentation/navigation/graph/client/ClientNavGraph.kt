package com.svstudio.eccomerceapp.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.ClientCategoryListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.order.list.ClientOrderListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.ClientProductListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
      navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ){
        composable (route = ClientScreen.ProductList.route) {
            ClientProductListScreen(navController)
        }
        composable (route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen(navController)
        }
        composable (route = ClientScreen.OrderList.route){
            ClientOrderListScreen(navController)
        }
        composable (route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
        ClientProductNavGraph(navController)
        ShoppingBagNavGraph(navController)
        ClientOrderNavGraph(navController)
    }
}