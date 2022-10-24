package com.example.users.visit

import com.github.terrakok.cicerone.androidx.FragmentScreen

class VisitHistoryScreen {

    fun create(): FragmentScreen = FragmentScreen {
        VisitHistoryFragment.newInstance()
    }
}