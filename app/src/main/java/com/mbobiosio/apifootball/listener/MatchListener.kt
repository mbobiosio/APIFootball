package com.mbobiosio.apifootball.listener

import com.mbobiosio.apifootball.model.Match

/*
* Created by Mbuodile Obiosio on Apr 21, 2021.
* Twitter: @cazewonder
* Nigeria
*/
interface MatchListener {
    fun onItemClicked(match: Match)
}