package com.mbobiosio.apifootball.model.response

import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class APIResponse(
    @Json(name = "status")
    val status: Int?,
    @Json(name = "message")
    val message: String?,
)
