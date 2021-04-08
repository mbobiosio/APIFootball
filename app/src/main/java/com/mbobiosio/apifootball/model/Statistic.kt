package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 08, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Statistic(
    @Json(name = "statistics")
    val statistics: List<Statistics>?
): Response