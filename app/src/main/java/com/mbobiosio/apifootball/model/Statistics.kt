package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 08, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Statistics(
    @Json(name = "type")
    val type: String?,
    @Json(name = "home")
    val home: String?,
    @Json(name = "away")
    val away: String?
): Response
