package com.svstudio.eccomerceapp.presentation.navigation.screen.client.profile

sealed class ProfileScreen (val  route: String) {
    object  ProfileUpdate: ProfileScreen("profile/update")
}