package com.example.users.screens.auth

import com.github.terrakok.cicerone.androidx.FragmentScreen

object AuthScreen {
    fun create() = FragmentScreen { AuthFragment.newInstance() }
}