package com.mbobiosio.apifootball.model.java

import com.squareup.moshi.Json

/*
 * Created by Mbuodile Obiosio on Apr 17, 2021.
 * Twitter: @cazewonder
 * Nigeria
 */
class Response<T> {
    private val error: Int? = null
    private val response: T? = null
    private val isSuccess: Boolean
        get() = error == 200
}

class ListData {
    private val id: String? = null
    private val account: String? = null
}

class Error {
    private val message: String? = null
}

class MainResponse {
    @Json(name = "error")
    private val error: Error? = null

    @Json(name = "msg")
    private val listData: List<ListData>? = null
}