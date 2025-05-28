package com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientScreen

@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currenDestination: NavDestination?,
    navController: NavHostController
){
  BottomNavigationItem(
      label = {
          Text(text = screen.title)
      },
      icon = {
          Icon(imageVector = screen.icon, contentDescription = "")
      },
      selected = currenDestination?.hierarchy?.any{
          it.route == screen.route
      } ==true,
      unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
      onClick = {
          navController.navigate(route = screen.route){
              popUpTo(navController.graph.findStartDestination().id)
          }
      },
      modifier = Modifier.background(Color.Black)


  )

}