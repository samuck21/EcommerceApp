package com.svstudio.eccomerceapp.domain.usecase.auth

import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository ){
    suspend operator fun invoke(user: User) = repository.updateSession(user)
}