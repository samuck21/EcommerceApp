package com.svstudio.eccomerceapp.presentation.scree_auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.svstudio.eccomerceapp.domain.until.Resource

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){
    var  state by mutableStateOf(LoginState())
        private set
    var errorMessage by mutableStateOf("")

    fun onEmailInput(email: String){
        state =state.copy(email=email)
    }
    fun onPasswordInput(password: String){
        state =state.copy(password=password)
    }
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    fun login() = viewModelScope.launch {
        if(isValidForm()){
            loginResponse = Resource.Loading
            val result = authUseCase.login(state.email,state.password)
            loginResponse= result
            Log.d("LoginViewModel","Response:${loginResponse}")
        }

    }

    fun isValidForm(): Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            return false
        }else if(state.password.length< 6){
            return false
        }
        return  true

    }


}