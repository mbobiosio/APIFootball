package com.mbobiosio.apifootball.model.response

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class BaseResponse<T : Response>(

    val games: List<T>
)
