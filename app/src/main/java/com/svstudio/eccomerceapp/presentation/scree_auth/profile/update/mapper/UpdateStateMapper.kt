package com.svstudio.eccomerceapp.presentation.scree_auth.profile.update.mapper

import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}