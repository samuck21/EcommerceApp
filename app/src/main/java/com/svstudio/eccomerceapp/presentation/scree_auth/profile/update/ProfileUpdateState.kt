package com.svstudio.eccomerceapp.presentation.scree_auth.profile.update

data class ProfileUpdateState(
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val image: String? = null,
)