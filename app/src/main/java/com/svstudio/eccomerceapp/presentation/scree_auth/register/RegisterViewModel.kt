package com.svstudio.eccomerceapp.presentation.scree_auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import com.svstudio.eccomerceapp.presentation.scree_auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private  val authUseCase: AuthUseCase): ViewModel() {


     var state by mutableStateOf(RegisterState())
         private set
    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    var errorMessage by mutableStateOf("")

    fun register() = viewModelScope.launch {
        if(isValidForm()) {

            registerResponse = Resource.Loading
            val result = authUseCase.register(state.toUser())
            registerResponse = result
        }

    }
    fun onNameInput(input: String){
        state = state.copy(name = input)
    }
    fun onLastNameInput(input: String){
        state = state.copy(lastname =   input)
    }
    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }
    fun onPhoneInput(input: String){
        state = state.copy(phone = input)
    }
    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }
    fun onConfirmPasswordInput(input: String){
        state = state.copy(confirmPassword = input)
    }
    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }
    fun isValidForm (): Boolean {
        if(state.name ==""){
            errorMessage = "Ingresa el Nombre"
            return false
        }
        else if(state.lastname ==""){
            errorMessage = "Ingresa el Apellido"
            return false
        }
        else if(state.email==""){
            errorMessage = "Ingresa el email"
            return false
        }
        else if(state.phone ==""){
            errorMessage = "Ingresa el telefono"
            return false
        }
        else if(state.password ==""){
            errorMessage = "Ingresa el password"
            return false
        }
        else if(state.confirmPassword ==""){
            errorMessage = "Confirma el password"
            return false
        }else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6){
           errorMessage ="la contrasena debe ser mayor a 6 caracteres"
            return false
            }
        else if(state.password != state.confirmPassword){
            errorMessage ="la contrasenas no coinciden"
            return false
        }
        return true








    }

}