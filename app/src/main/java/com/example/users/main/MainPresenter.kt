package com.example.users.main

import com.example.users.auth.AuthScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AuthScreen.create())
    }

    fun back() = router.exit()
}