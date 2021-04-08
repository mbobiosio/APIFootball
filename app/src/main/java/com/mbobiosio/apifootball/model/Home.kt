package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Home(
    @Json(name = "time")
    var time: String?,
    @Json(name = "substitution")
    var substitution: String? = null
) : Response
