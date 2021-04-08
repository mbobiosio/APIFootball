package com.mbobiosio.apifootball.model.response

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Error(val code: Int? = null, val error: APIResponse? = null) : Result<Nothing>()
    object NetworkError : Result<Nothing>()
}