package com.svstudio.eccomerceapp.presentation.scree_auth.profile

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.componets.ProfileContent

@Composable
fun ProfileScreen(){
    Scaffold {
        ProfileContent(it)
    }

}