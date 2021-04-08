package com.mbobiosio.apifootball.model

import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Away(
    @Json(name = "time")
    var time: String?,
    @Json(name = "substitution")
    var substitution: String?
)
