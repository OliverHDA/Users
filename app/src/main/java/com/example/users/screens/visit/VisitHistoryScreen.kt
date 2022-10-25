package com.example.users.screens.visit

import com.example.users.model.Authentication
import com.github.terrakok.cicerone.androidx.FragmentScreen

class VisitHistoryScreen {

    fun create(user: String, authentication: Authentication): FragmentScreen = FragmentScreen {
        VisitHistoryFragment.newInstance(user, authentication)
    }
}