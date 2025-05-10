package com.svstudio.eccomerceapp.presentation.scree_auth.profile.info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private  val authUseCase: AuthUseCase): ViewModel() {
   var user by mutableStateOf<User?>(null)
       private set
    init {
        getSessionData()
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