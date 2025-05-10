package com.svstudio.eccomerceapp.domain.usecase.auth

import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.repository.AuthRepository

class LogoutUseCase constructor(private  val repository: AuthRepository) {
   suspend operator fun  invoke() = repository.logout()
}