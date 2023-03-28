package com.nikasov.data.repository.base

import com.nikasov.common.utils.DataState
import com.nikasov.common.utils.ErrorModel
import retrofit2.Response

typealias Mapper<Input, Output> = (Input) -> Output

abstract class BaseRepository {

    fun <I, O> obtain(
        request: Response<I?>,
        mapper: Mapper<I?, O?> = { null }
    ): DataState<O> {
        return try {
            val mappedResponseBody = mapper(request.body())
            if (request.isSuccessful) {
                //successful request with empty body will be unsuccessful
                DataState.successes(mappedResponseBody)
            } else {
                DataState.error(ErrorModel.create())
            }
        } catch (e: Exception) {
            DataState.error(ErrorModel.create())
        }
    }

    fun <M> obtain(request: Response<M?>): DataState<M> {
        return try {
            if (request.isSuccessful) {
                DataState.Success(request.body())
            } else {
                DataState.Error(ErrorModel.create())
            }
        } catch (e: Exception) {
            DataState.Error(ErrorModel.create())
        }
    }

}