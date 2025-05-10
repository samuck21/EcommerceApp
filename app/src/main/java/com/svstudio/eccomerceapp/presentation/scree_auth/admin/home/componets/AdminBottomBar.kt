package com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.componets

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientScreen

@Composable
fun AdminBottomBar(navController: NavHostController){
    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val  bottomBarDestination= screens.any{
        it.route == currentDestination?.route
    }
    if(bottomBarDestination){
        BottomNavigation (){
            screens.forEach { screen->
                  AdminBottomBarItem(
                      screen=screen,
                      currenDestination = currentDestination,
                      navController = navController

                  )
            }
        }
    }

}