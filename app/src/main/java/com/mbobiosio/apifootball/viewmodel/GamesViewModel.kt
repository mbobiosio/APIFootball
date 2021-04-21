package com.mbobiosio.apifootball.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.footballbuzz.android.model.games.Match
import com.mbobiosio.apifootball.model.MatchID
import com.mbobiosio.apifootball.model.Statistic
import com.mbobiosio.apifootball.model.Statistics
import com.mbobiosio.apifootball.model.response.Result
import com.mbobiosio.apifootball.repos.MatchRepository
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class GamesViewModel : ViewModel() {

    private val matchRepository = MatchRepository()

    private val _games = MutableLiveData<List<Match>?>()
    val games: LiveData<List<Match>?> get() = _games

    private val _statistics = MutableLiveData<ResponseBody?>()
    val statistics: LiveData<ResponseBody?> get() = _statistics

    fun fetchGames(leagueId: String, action: String, from: String, to: String, apiKey: String) {
        viewModelScope.launch {
            when(val result = getGames(leagueId, action, from, to, apiKey)) {
                is Result.Success -> _games.postValue(result.value)
                else -> Result.Error()
            }
        }
    }

    fun getStatistics(action: String?, matchId: Int?, apiKey: String?) {
        viewModelScope.launch {
            when(val result = statistics(action, matchId, apiKey)) {
                is Result.Success -> _statistics.postValue(result.value)
                else -> Result.Error()
            }
        }
    }

    private suspend fun getGames(leagueId: String?, action: String?, from: String?, to: String?, apiKey: String?) = matchRepository.getGames(leagueId, action, from, to, apiKey)
    private suspend fun statistics(action: String?, matchId: Int?, apiKey: String?) = matchRepository.getStatistics(action, matchId, apiKey)
}