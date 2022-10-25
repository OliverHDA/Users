package com.example.users.screens.auth

import com.example.users.model.Response
import com.example.users.model.User
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface AuthView : MvpView {

    @AddToEndSingle
    fun setUsers(users: List<User>)

    @Skip
    fun signIn(response: Response)

    @Skip
    fun error(e: Throwable)
}