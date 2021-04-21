package com.mbobiosio.apifootball.repos

import com.mbobiosio.apifootball.api.RetrofitClient
import com.mbobiosio.apifootball.model.Statistic
import com.mbobiosio.apifootball.model.response.Result
import okhttp3.ResponseBody

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
    ): Result<ResponseBody> {
        return coroutineHandler(dispatcher) {
            apiService.getGames(leagueId, action, from, to, apiKey)
        }
    }

    suspend fun getStatistics(
        action: String?,
        matchId: Int?,
        apiKey: String?
    ): Result<Map<String, Statistic?>> {
        return coroutineHandler(dispatcher) {
            apiService.getStatistics(action, matchId, apiKey)
        }
    }
}