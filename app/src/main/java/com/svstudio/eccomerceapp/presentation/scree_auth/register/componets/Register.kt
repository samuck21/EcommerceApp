package com.svstudio.eccomerceapp.presentation.scree_auth.register.componets

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.navigation.screen.AuthScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController,vm: RegisterViewModel = hiltViewModel()){
    when(val response = vm.registerResponse){
        Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }

        }
        is Resource.Success ->{
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                /*
                navController.navigate(route = AuthScreen.Home.route){

                    popUpTo(AuthScreen.Register.route){inclusive = true}
                }*/
            }


        }
        is Resource.Failure ->{
            Toast.makeText(LocalContext.current,response.message, Toast.LENGTH_SHORT).show()

        }
        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current,"Hubo un error desconocido", Toast.LENGTH_SHORT).show()
            }
    }
}
}