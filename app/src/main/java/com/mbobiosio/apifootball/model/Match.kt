package com.mbobiosio.apifootball.model

import com.mbobiosio.apifootball.model.Card
import com.mbobiosio.apifootball.model.Goalscorer
import com.mbobiosio.apifootball.model.Substitutions
import com.mbobiosio.apifootball.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Match(
    @Json(name = "match_id")
    val matchId: String?,

    @Json(name = "country_id")
    val countryId: String?,

    @Json(name = "country_name")
    var countryName: String?,

    @Json(name = "league_id")
    var leagueId: String?,

    @Json(name = "league_name")
    var leagueName: String?,

    @Json(name = "match_date")
    var matchDate: String?,

    @Json(name = "match_status")
    var matchStatus: String?,

    @Json(name = "match_time")
    var matchTime: String?,

    @Json(name = "match_hometeam_id")
    var matchHomeTeamId: String?,

    @Json(name = "match_hometeam_name")
    var matchHomeTeamName: String?,

    @Json(name = "match_hometeam_score")
    var matchHomeTeamScore: String?,

    @Json(name = "match_awayteam_name")
    var matchAwayTeamName: String?,

    @Json(name = "match_awayteam_id")
    var matchAwayTeamId: String?,

    @Json(name = "match_awayteam_score")
    var matchAwayTeamScore: String?,

    @Json(name = "match_hometeam_halftime_score")
    var matchHomeTeamHalftimeScore: String?,

    @Json(name = "match_awayteam_halftime_score")
    var matchAwayTeamHalftimeScore: String?,

    @Json(name = "match_hometeam_extra_score")
    var matchHomeTeamExtraScore: String?,

    @Json(name = "match_awayteam_extra_score")
    var matchAwayTeamExtraScore: String?,

    @Json(name = "match_hometeam_penalty_score")
    var matchHomeTeamPenaltyScore: String?,

    @Json(name = "match_awayteam_penalty_score")
    var matchAwayTeamPenaltyScore: String?,

    @Json(name = "match_hometeam_ft_score")
    var matchHomeTeamFtScore: String?,

    @Json(name = "match_awayteam_ft_score")
    var matchAwayTeamFtScore: String?,

    @Json(name = "match_hometeam_system")
    var matchHomeTeamSystem: String?,

    @Json(name = "match_awayteam_system")
    var matchAwayTeamSystem: String?,

    @Json(name = "match_live")
    var matchLive: String?,

    @Json(name = "match_round")
    var matchRound: String?,

    @Json(name = "match_stadium")
    var matchStadium: String?,

    @Json(name = "match_referee")
    var matchReferee: String?,

    @Json(name = "team_home_badge")
    var teamHomeBadge: String?,

    @Json(name = "team_away_badge")
    var teamAwayBadge: String?,

    @Json(name = "goalscorer")
    var goalscorer: List<Goalscorer>?,

    @Json(name = "cards")
    var cards: List<Card>?,

    @Json(name = "substitutions")
    var substitutions: Substitutions?,

    /*@Json(name = "lineup")
    var lineup: Lineup?,

    @Json(name = "statistics")
    var statistics: List<Statistic>?,*/

    @Json(name = "message")
    var message: String?,

    @Json(name = "code")
    var code: String?,

    @Json(name = "error")
    var error: String?,
): Response