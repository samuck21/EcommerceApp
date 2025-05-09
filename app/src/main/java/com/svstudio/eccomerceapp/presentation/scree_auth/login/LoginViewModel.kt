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
import com.svstudio.eccomerceapp.presentation.scree_auth.login.components.Login
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterScreen

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
    init {
        getSessionData()
    }
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect { data ->
            if(!data.token.isNullOrBlank()){
               loginResponse = Resource.Success(data)

                Log.d("LoginViewModel","Null")
            }

        }

    }
    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }
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