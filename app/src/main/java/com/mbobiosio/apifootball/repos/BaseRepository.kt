package com.mbobiosio.apifootball.repos

import com.mbobiosio.apifootball.model.response.APIResponse
import com.mbobiosio.apifootball.model.response.Result
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
open class BaseRepository {

    suspend fun <T> coroutineHandler(
        dispatcher: CoroutineDispatcher,
        apiRequest: suspend () -> T
    ): Result<T> {
        return withContext(dispatcher) {
            try {
                Result.Success(apiRequest.invoke())
            } catch (e: IOException) {
                Result.NetworkError
            } catch (e: HttpException) {
                val errorCode = e.code()
                val errorMessage = throwableResponse(e)
                Timber.d("Network Error $errorCode : ${errorMessage?.status} : ${errorMessage?.message}")
                Result.Error(errorCode, errorMessage)
            }
        }
    }

    open val dispatcher = Dispatchers.IO

    private fun throwableResponse(e: HttpException): APIResponse? {
        return try {
            e.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
                    .adapter(APIResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (t: Throwable) {
            Timber.d(t)
            null
        }
    }
}