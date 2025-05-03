package com.svstudio.eccomerceapp.domain.usecase.auth

import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.repository.AuthRepository

class SaveSessionUseCase constructor( private  val repository: AuthRepository) {
   suspend operator fun  invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}