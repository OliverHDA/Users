package com.example.users.data.localstorage.historymapper

import com.example.users.data.localstorage.HistoryEntity
import com.example.users.model.Authentication

interface HistoryMapper {
    fun toHistoryEntity(uid: String, authentication: Authentication): HistoryEntity
    fun toAuthentication(entity: HistoryEntity): Authentication
}