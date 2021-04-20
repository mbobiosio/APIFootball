package com.mbobiosio.apifootball.api

import com.footballbuzz.android.model.games.Match
import com.mbobiosio.apifootball.model.MatchID
import com.mbobiosio.apifootball.model.Statistic
import com.mbobiosio.apifootball.model.Statistics
import com.mbobiosio.apifootball.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
interface APIService {

    /*Games*/
    @GET(Constants.GAMES_BASE_URL)
    suspend fun getGames(
        @Query("league_id") leagueId: String?,
        @Query("action") action: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("APIkey") apiKey: String?
    ): List<Match>

    @GET(Constants.GAMES_BASE_URL)
    suspend fun getStatistics(
        @Query("action") leagueId: String?,
        @Query("match_id") matchId: Int?,
        @Query("APIkey") apiKey: String?
    ): Map<String, Any?>
}