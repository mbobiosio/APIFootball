package com.mbobiosio.apifootball

import android.app.Application
import com.mbobiosio.apifootball.util.ReleaseTree
import timber.log.Timber

/*
 * Created by Mbuodile Obiosio on Apr 05, 2021.
 * Twitter: @cazewonder
 * Nigeria
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant(ReleaseTree())
        }
    }
}