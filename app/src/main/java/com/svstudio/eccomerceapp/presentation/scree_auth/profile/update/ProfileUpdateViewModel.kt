package com.svstudio.eccomerceapp.presentation.scree_auth.profile.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(private  val authUseCase: AuthUseCase): ViewModel() {
   var user by mutableStateOf<User?>(null)
       private set

    var state by mutableStateOf(RegisterState())
        private set
    init {
        getSessionData()
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
    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect { data->
            user = data.user
        }
    }
}