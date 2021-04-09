package com.mbobiosio.apifootball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.mbobiosio.apifootball.databinding.ActivityMainBinding
import com.mbobiosio.apifootball.model.MatchID
import com.mbobiosio.apifootball.model.Statistic
import com.mbobiosio.apifootball.util.Constants
import com.mbobiosio.apifootball.viewmodel.GamesViewModel
import org.json.JSONObject
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<GamesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        /*viewModel.fetchGames("148", "get_events", "2021-04-03", "2021-04-03", "9c1b64150701b5b94ce8dfd58c515456d6baea113c4f483ca345328b1ca0db41")

        viewModel.games.observe(this) {
            it?.let {
                Timber.d("$it")
            }
        }*/

        val matchId = 411469

        viewModel.getStatistics("get_statistics", matchId, "9c1b64150701b5b94ce8dfd58c515456d6baea113c4f483ca345328b1ca0db41")

        viewModel.statistics.observe(this) {
            it?.let {
                val statistic: Statistic? = it[matchId.toString()]
                Timber.d("$statistic")
            }
        }
    }
}