package com.example.users.screens.signinhistory

import com.example.users.model.Authentication
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface SignInHistoryView : MvpView {
    fun show(list: List<Authentication>)
    fun error(e: Throwable)
}