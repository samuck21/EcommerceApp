package com.svstudio.eccomerceapp.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.profile.ProfileScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileScreen.ProfileUpdate.route+"/{user}",
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, userParam = it)
            }
        }

    }
}