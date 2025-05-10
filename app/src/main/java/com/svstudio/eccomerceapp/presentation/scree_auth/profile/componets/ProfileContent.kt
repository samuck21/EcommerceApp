package com.svstudio.eccomerceapp.presentation.scree_auth.profile.componets

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.widget.Button
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.MainActivity
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.ProfileViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(paddingValues: PaddingValues,vm: ProfileViewModel= hiltViewModel()){
    val activity = LocalContext.current as? Activity
    Text(
        modifier =  Modifier.padding(paddingValues=paddingValues),
        text = " Profile Screen"
    )
    androidx.compose.material.Button(
        onClick = {
        vm.logout()
            activity?.finish()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
    },
       ) { Text("Cerrar Cession")}
}