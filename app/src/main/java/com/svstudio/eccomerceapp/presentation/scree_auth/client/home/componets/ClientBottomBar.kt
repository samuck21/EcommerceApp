package com.svstudio.eccomerceapp.presentation.scree_auth.client.home.componets

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController){
    val screen = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.OrderList,
        ClientScreen.Profile
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val  bottomBarDestination= screen.any{
        it.route == currentDestination?.route
    }
    if(bottomBarDestination){
        BottomNavigation (){
            screen.forEach { screen->
                  ClientBottomBarItem(
                      screen=screen,
                      currenDestination = currentDestination,
                      navController = navController

                  )
            }
        }
    }

}