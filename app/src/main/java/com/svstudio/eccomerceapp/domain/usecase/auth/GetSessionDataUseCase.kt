package com.svstudio.eccomerceapp.domain.usecase.auth

import com.svstudio.eccomerceapp.domain.repository.AuthRepository

class GetSessionDataUseCase constructor( private  val repository: AuthRepository) {
    operator fun  invoke() = repository.getSessionData()
}