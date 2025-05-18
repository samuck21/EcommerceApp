package com.svstudio.eccomerceapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminCategoryScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.roles.RolesScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.AdminCategoryUpdateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.AdminHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.ClientHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){

        composable( route = AdminCategoryScreen.CategoryCreate.route) {
            AdminCategoryCreateScreen(navController = navController)
        }
        composable( route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument ("category") {
                type = NavType.StringType
            })

        ) {
            it.arguments?.getString("category")?.let {
                AdminCategoryUpdateScreen(navController = navController,it)
            }

        }

    }
}