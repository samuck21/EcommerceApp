package com.svstudio.eccomerceapp.presentation.scree_auth.roles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class RolesViewModel @Inject constructor(private  val authUseCase: AuthUseCase): ViewModel() {
    var authResponse by mutableStateOf(AuthResponse)


}