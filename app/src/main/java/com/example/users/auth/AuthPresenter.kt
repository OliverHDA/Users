package com.example.users.auth

import com.example.users.model.User
import com.example.users.visit.VisitHistoryScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class AuthPresenter(
    private val router: Router
) : MvpPresenter<AuthView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setUsers(listOf())
    }

    fun signIn(user: User) {
        router.navigateTo(VisitHistoryScreen().create())
    }
}