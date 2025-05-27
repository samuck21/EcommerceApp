package com.svstudio.eccomerceapp.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen (
    val  route: String,
    val title: String,
    val icon: ImageVector

    ) {
    object  CategoryList: AdminScreen(
        route = "admin/category/list",
        title = "Categorias",
        icon = Icons.Default.List
    )
    object  OrderList: AdminScreen(
        route = "admin/order/list",
        title = "Pedidos",
        icon = Icons.Default.Info
    )
//    object  ProductList: AdminScreen(
//        route = "admin/product/list",
//        title = "Productos",
//        icon = Icons.Default.ThumbUp
//    )
    object  Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}