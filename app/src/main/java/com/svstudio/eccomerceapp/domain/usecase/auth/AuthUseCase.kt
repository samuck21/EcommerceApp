package com.svstudio.eccomerceapp.domain.usecase.auth

data class AuthUseCase(
    val  login: LoginUseCase,
    val  register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutUseCase,
    val updateSession: UpdateSessionUseCase

)
