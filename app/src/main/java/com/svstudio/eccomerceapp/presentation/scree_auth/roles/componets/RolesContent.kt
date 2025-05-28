package com.svstudio.eccomerceapp.presentation.scree_auth.roles.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.RolesViewModel

@Composable

fun RolesContent(paddingValues: PaddingValues,navController: NavHostController, vm: RolesViewModel = hiltViewModel()){
    val data = vm.authResponse.user
    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(com.svstudio.eccomerceapp.R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    Text("Hola")
    LazyRow  (modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize(),
        verticalAlignment =Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

        ) {
        items (items = data?.roles?: arrayListOf()) {rol ->
           RolesItem(rol, navController = navController)
        }
    }

}