package com.nikasov.common.extensions

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.*

val defaultTimeZone: ZonedDateTime
    get() = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault())

val currentDateTimeInMillis: Long
    get() = LocalDateTime.now().toEpochSecond(defaultTimeZone.offset)

fun TemporalAccessor.byPattern(pattern: String): String =
    DateTimeFormatter.ofPattern(pattern, Locale.US).format(this)
