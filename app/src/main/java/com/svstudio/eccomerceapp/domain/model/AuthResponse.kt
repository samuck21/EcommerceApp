package com.svstudio.eccomerceapp.domain.model

data class AuthResponse(
    val user: User,
    val token: String
)
