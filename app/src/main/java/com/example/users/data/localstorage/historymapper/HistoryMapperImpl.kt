package com.example.users.data.localstorage.historymapper

import com.example.users.data.localstorage.HistoryEntity
import com.example.users.model.Authentication
import javax.inject.Inject

class HistoryMapperImpl @Inject constructor(): HistoryMapper {

    override fun toHistoryEntity(uid: String, authentication: Authentication): HistoryEntity =
        HistoryEntity(
            id = 0,
            uid = uid,
            response = authentication.response,
            continueWork =  authentication.continueWork,
            photoHash = authentication.photoHash,
            currentDate = authentication.currentDate
        )

    override fun toAuthentication(entity: HistoryEntity): Authentication =
        Authentication(
            response = entity.response,
            continueWork =  entity.continueWork,
            photoHash = entity.photoHash,
            currentDate = entity.currentDate
        )
}