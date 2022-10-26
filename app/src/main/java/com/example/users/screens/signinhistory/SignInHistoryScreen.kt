package com.example.users.screens.signinhistory

import com.example.users.model.Authentication
import com.github.terrakok.cicerone.androidx.FragmentScreen

class SignInHistoryScreen {

    fun create(uid: String, user: String, authentication: Authentication): FragmentScreen = FragmentScreen {
        SignInHistoryFragment.newInstance(uid, user, authentication)
    }
}