package com.example.users.screens.signinhistory

import com.example.users.model.Authentication
import com.example.users.utils.ISchedulers
import moxy.MvpPresenter

class SignInHistoryPresenter(
    private val schedulers: ISchedulers,
    private val newAuthentication: Authentication
) : MvpPresenter<SignInHistoryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val list = mutableListOf(newAuthentication)
        viewState.show(list)
    }
}