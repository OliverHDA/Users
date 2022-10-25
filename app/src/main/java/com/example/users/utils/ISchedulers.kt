package com.example.users.utils

import io.reactivex.Scheduler

interface ISchedulers {
    val ui: Scheduler
    val io: Scheduler
}