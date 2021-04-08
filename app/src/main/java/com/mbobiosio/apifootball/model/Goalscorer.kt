package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Goalscorer(
    @Json(name = "time")
    val scoreTime: String?,

    @Json(name = "home_scorer")
    val homeScorer: String?,

    @Json(name = "score")
    val score: String?,

    @Json(name = "away_scorer")
    val awayScorer: String?,

    @Json(name = "info")
    val info: String?,
): Response
