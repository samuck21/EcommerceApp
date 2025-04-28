package com.svstudio.eccomerceapp.presentation.scree_auth.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavController

@Composable

fun HomeScreen(navController: NavController){
    Scaffold () { paddingValues ->
        Text(
            modifier = Modifier.padding( paddingValues=paddingValues),
            text = "HomeScreen"
        )

    }
}