package com.example.users.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersProvider @Inject constructor(): ISchedulers {
    override val ui: Scheduler = AndroidSchedulers.mainThread()
    override val io: Scheduler = Schedulers.io()
}