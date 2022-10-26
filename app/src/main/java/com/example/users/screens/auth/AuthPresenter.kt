package com.example.users.screens.auth

import com.example.users.data.repository.RemoteRepository
import com.example.users.model.Authentication
import com.example.users.model.User
import com.example.users.screens.signinhistory.SignInHistoryScreen
import com.example.users.utils.ISchedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter

class AuthPresenter(
    private val router: Router,
    private val remoteRepository: RemoteRepository,
    private val schedulers: ISchedulers
) : MvpPresenter<AuthView>() {

    private val compositeDisposable = CompositeDisposable()
    private var currentUser: User? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        compositeDisposable.addAll(
            remoteRepository
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
            remoteRepository
                .signIn(uid, pass)
                .observeOn(schedulers.ui)
                .subscribe(
                    { viewState.signIn(it) },
                    { viewState.error(it) }
                )
        )
    }

    fun signIn(authentication: Authentication) {
        currentUser?.let {
            router.navigateTo(SignInHistoryScreen().create(it.user, it.uid, authentication))
        }

    }

    fun setCurrentUser(user: User) {
        currentUser = user
        viewState.initSignInButton(user.uid)
    }

    fun getCurrentUser(): User? = currentUser

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}