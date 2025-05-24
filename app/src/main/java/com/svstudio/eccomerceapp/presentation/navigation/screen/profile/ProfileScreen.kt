package com.svstudio.eccomerceapp.presentation.navigation.screen.profile

sealed class ProfileScreen (val  route: String) {
    object  ProfileUpdate: ProfileScreen("profile/update")
}