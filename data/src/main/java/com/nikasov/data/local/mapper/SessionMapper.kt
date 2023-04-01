package com.nikasov.data.local.mapper

import com.nikasov.common.extensions.defaultTimeZone
import com.nikasov.data.local.entity.SessionAndAdvice
import nikasov.domain.entitiy.Session
import java.time.LocalDateTime
import javax.inject.Inject

class SessionMapper @Inject constructor(
    private val mapper: AdviceMapper
) {

    fun map(sessionAndAdvice: SessionAndAdvice): Session {
        return Session(
            id = sessionAndAdvice.session.sessionId,
            title = sessionAndAdvice.session.title,
            date = LocalDateTime.ofEpochSecond(sessionAndAdvice.session.date, 0, defaultTimeZone.offset),
            advices = sessionAndAdvice.adviceList.map { mapper.mapFromEntity(it) }
        )
    }

}