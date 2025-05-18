package com.svstudio.eccomerceapp.presentation.scree_auth.profile.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterState
import com.svstudio.eccomerceapp.presentation.scree_auth.util.ComposeFileProvider
import com.svstudio.eccomerceapp.presentation.scree_auth.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private  val authUseCase: AuthUseCase,
    @ApplicationContext private val context: Context
): ViewModel() {

    var user by mutableStateOf<User?>(null)
       private set

    var state by mutableStateOf(RegisterState())
        private set
    init {
        getSessionData()
    }

    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()


    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if(result != null){
            file = ComposeFileProvider.createFileFromUri(context,result)
          //  state = state.copy(image = result.toString())
        }

    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if(result != null){
            state =state.copy(ComposeFileProvider.getPathFromBitmap(context,result))
            //file = File(state.image)
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
    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect { data->
            user = data.user
        }
    }
}