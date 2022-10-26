package com.example.users.screens.signinhistory

import com.example.users.data.repository.LocalRepository
import com.example.users.model.Authentication
import com.example.users.utils.ISchedulers
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter

class SignInHistoryPresenter(
    private val schedulers: ISchedulers,
    private val repository: LocalRepository,
    private val uid: String,
    private val newAuthentication: Authentication
) : MvpPresenter<SignInHistoryView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (uid.isNotEmpty()) {
            compositeDisposable.addAll(
                repository
                    .getHistory(uid)
                    .map {
                        it.add(newAuthentication)
                        it
                    }
                    .subscribeOn(schedulers.io)
                    .observeOn(schedulers.ui)
                    .subscribe(
                        {
                            addToHistory()
                            viewState.show(it)
                        },
                        viewState::error
                    )
            )
        }
    }

    private fun addToHistory() {
        if (uid.isNotEmpty()) {
            compositeDisposable.addAll(
                repository
                    .add(uid, newAuthentication)
                    .subscribeOn(schedulers.io)
                    .observeOn(schedulers.ui)
                    .subscribe(
                        {},
                        viewState::error
                    )
            )
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}