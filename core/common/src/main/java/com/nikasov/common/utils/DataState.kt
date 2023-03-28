package com.nikasov.common.utils

sealed class DataState<out R> {
    data class Success<out T>(val data: T?) : DataState<T>()
    data class Error(val errorModel: ErrorModel) : DataState<Nothing>()

    companion object {
        fun <T> successes(data: T?) = Success(data)
        fun error(errorModel: ErrorModel) = Error(ErrorModel.create())
    }

    fun getResult(
        successes: (R?) -> Unit,
        error: ((String) -> Unit)
    ) {
        when (this) {
            is Success -> successes(data)
            is Error -> error(errorModel)
        }
    }

}