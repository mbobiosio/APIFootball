package com.mbobiosio.apifootball

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mbobiosio.apifootball.api.getMatchAdapter
import com.mbobiosio.apifootball.databinding.ActivityMainBinding
import com.mbobiosio.apifootball.listener.MatchListener
import com.mbobiosio.apifootball.model.Match
import com.mbobiosio.apifootball.viewmodel.GamesViewModel
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<GamesViewModel>()
    private lateinit var adapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initRecyclerView()

        viewModel.fetchGames(
            "148",
            "get_events",
            "2021-04-03",
            "2021-04-03",
            "9c1b64150701b5b94ce8dfd58c515456d6baea113c4f483ca345328b1ca0db41"
        )

        viewModel.games.observe(this) {
            it?.let {
                when (val json = JSONTokener(it.string()).nextValue()) {
                    is JSONObject -> {
                        val msg: String? = json["message"] as String?
                        val err: Number? = json["error"] as Number?
                        Timber.d("error: $err, message: $msg")
                        Toast.makeText(this, "Wrong api key", Toast.LENGTH_LONG).show()
                    }
                    is JSONArray -> {
                        val matchList = mutableListOf<Match>()
                        for (i in 0 until json.length()) {
                            val data = json.getJSONObject(i)
                            Timber.d("$data")
                            val match = getMatchAdapter().fromJson(data.toString())
                            if (match != null) {
                                matchList.add(match)
                            }
                        }
                        adapter.submitList(matchList)
                    }
                    else -> {
                        Timber.d("Unexpected response")
                    }
                }
            }
        }

        val matchId = 411469

        /*viewModel.getStatistics("get_statistics", matchId, "9c1b64150701b5b94ce8dfd58c515456d6baea113c4f483ca345328b1ca0db41")

        viewModel.statistics.observe(this) {
            it?.let {
                val statistic: Statistic? = it[matchId.toString()]
                Timber.d("$statistic")
            }
        }*/
    }
    private fun initRecyclerView() {
        adapter = MatchAdapter(object : MatchListener {
            override fun onItemClicked(match: Match) {
                Timber.d("${match.matchHomeTeamName} vs ${match.matchAwayTeamName}")
            }
        })
        binding.games.adapter = adapter
    }
}