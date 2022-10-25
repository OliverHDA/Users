package com.example.users.screens.auth

import com.example.users.data.repository.Repository
import com.example.users.model.Authentication
import com.example.users.screens.visit.VisitHistoryScreen
import com.example.users.utils.ISchedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import java.util.*

class AuthPresenter(
    private val router: Router,
    private val repository: Repository,
    private val schedulers: ISchedulers
) : MvpPresenter<AuthView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        compositeDisposable.addAll(
            repository
                .getUsers()
                .observeOn(schedulers.ui)
                .subscribe(
                    { viewState.setUsers(it.users.users) },
                    { viewState.error(it) }
                )
        )
    }

    fun onSignInClick(uid: String, pass: String) {
        compositeDisposable.addAll(
            repository
                .signIn(uid, pass)
                .observeOn(schedulers.ui)
                .subscribe(
                    { viewState.signIn(it) },
                    { viewState.error(it) }
                )
        )
    }

    fun signIn(user: String, authentication: Authentication) {
        router.navigateTo(VisitHistoryScreen().create(user, authentication))
    }
}