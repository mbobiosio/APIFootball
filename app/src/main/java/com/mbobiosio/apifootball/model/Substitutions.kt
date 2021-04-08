package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Substitutions(
    @Json(name = "home")
    var home: List<Home>?,

    @Json(name = "away")
    var away: List<Away>?
) : Response