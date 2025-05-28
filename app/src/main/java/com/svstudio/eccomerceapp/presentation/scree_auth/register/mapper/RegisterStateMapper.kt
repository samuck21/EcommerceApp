package com.svstudio.eccomerceapp.presentation.scree_auth.register.mapper

import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.presentation.scree_auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}