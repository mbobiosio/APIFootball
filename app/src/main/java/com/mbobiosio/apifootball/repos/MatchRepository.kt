package com.mbobiosio.apifootball.repos

import com.mbobiosio.apifootball.model.Match
import com.mbobiosio.apifootball.api.RetrofitClient
import com.mbobiosio.apifootball.model.Statistic
import com.mbobiosio.apifootball.model.response.Result

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class MatchRepository : BaseRepository() {

    private val apiService = RetrofitClient.apiService

    suspend fun getGames(
        leagueId: String?,
        action: String?,
        from: String?,
        to: String?,
        apiKey: String?
    ): Result<List<Match>> {
        return coroutineHandler(dispatcher) {
            apiService.getGames(leagueId, action, from, to, apiKey)
        }
    }
}