package com.mbobiosio.apifootball

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mbobiosio.apifootball.databinding.ActivityMainBinding
import com.mbobiosio.apifootball.model.Match
import com.mbobiosio.apifootball.viewmodel.GamesViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(), (Match) -> Unit {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<GamesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel.fetchGames("149", "get_events", "2021-04-24", "2021-04-24", "588661df9232f2e7762d61e6b92185acf74fb95691b847ad13bc23fd6b3665cd")

        val adapter = GamesAdapter(this)
        binding.games.adapter = adapter
        viewModel.games.observe(this) {
            it?.let {
                Timber.d("$it")
                adapter.submitList(it)
            }
        }

    }

    override fun invoke(match: Match) {
        val intent = Intent(this, GameDetailActivity::class.java)
        startActivity(intent)
    }
}