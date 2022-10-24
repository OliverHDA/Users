package com.example.users.auth

import com.example.users.model.User
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface AuthView : MvpView {
    fun setUsers(users: List<User>)
    fun error(e: Throwable)
}