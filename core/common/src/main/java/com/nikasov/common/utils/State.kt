package com.nikasov.common.utils

sealed class State<out T> {

    object Idle: State<Nothing>()
    data class Loading<out T>(val data: T?) : State<T>()
    data class Successes<out T>(val data: T) : State<T>()
    data class Error(val errorModel: String) : State<Nothing>()

    companion object {
        fun <T> loading(data: T? = null) = Loading(data)
        fun <T> successes(data: T) = Successes(data)
        fun error(errorModel: String? = null) = Error(errorModel ?: "")
    }

    fun asSuccess(): Successes<T>? {
        return this as? Successes
    }
}