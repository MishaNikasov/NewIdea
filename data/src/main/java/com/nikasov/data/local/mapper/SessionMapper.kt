package com.nikasov.data.local.mapper

import com.nikasov.data.local.entity.SessionAndAdvice
import com.nikasov.data.local.entity.SessionEntity
import nikasov.domain.entitiy.Advice
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class SessionMapper @Inject constructor(
    private val mapper: AdviceMapper
) {

    fun map(list: List<Advice>): SessionAndAdvice {
        val date = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
        return SessionAndAdvice(
            session = SessionEntity(date = date),
            adviceList = list.map { mapper.map(it) }
        )
    }

}