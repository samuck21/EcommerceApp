package com.svstudio.eccomerceapp.domain.usecase.auth

import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.until.Resource

class RegisterUseCase (private val authRepository: AuthRepository){
     suspend operator fun invoke(user: User) = authRepository.register(user)
 }
