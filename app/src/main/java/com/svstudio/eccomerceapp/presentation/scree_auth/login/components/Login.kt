package com.svstudio.eccomerceapp.presentation.scree_auth.login.components

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
import com.svstudio.eccomerceapp.presentation.scree_auth.login.LoginViewModel
import  com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.AuthScreen

@Composable
fun Login(navController: NavController,vm: LoginViewModel = hiltViewModel()){
    when(val response = vm.loginResponse){
        Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }

        }
        is Resource.Success ->{
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)


                if(response.data.user?.roles!!.size > 1 ){
                    navController.navigate(route = Graph.ROLES){
                        popUpTo(Graph.ROLES){inclusive = true}
                    }
                }else{
                    navController.navigate(route = Graph.CLIENT){
                        popUpTo(Graph.ROLES){inclusive = true}
                    }
                }


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