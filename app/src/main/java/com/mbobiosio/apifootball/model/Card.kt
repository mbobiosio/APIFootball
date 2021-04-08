package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Card(
    @Json(name = "time")
    var time: String?,

    @Json(name = "home_fault")
    var homeFault: String?,

    @Json(name = "card")
    var card: String?,

    @Json(name = "away_fault")
    var awayFault: String?,

    @Json(name = "info")
    var info: String?
) : Response
