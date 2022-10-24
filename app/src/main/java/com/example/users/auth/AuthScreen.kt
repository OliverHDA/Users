package com.example.users.auth

import com.github.terrakok.cicerone.androidx.FragmentScreen

object AuthScreen {
    fun create() = FragmentScreen { AuthFragment.newInstance() }
}