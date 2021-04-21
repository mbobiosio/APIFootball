package com.mbobiosio.apifootball.api

import com.mbobiosio.apifootball.model.Match
import com.mbobiosio.apifootball.util.Constants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/*
* Created by Mbuodile Obiosio on Apr 05, 2021.
* Twitter: @cazewonder
* Nigeria
*/
object RetrofitClient {
    val apiService by lazy { retrofitService<APIService>() }
}

private fun httpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
    }.build()
}

private fun getMoshi(): Moshi {
    return Moshi.Builder().apply {
        this.add(KotlinJsonAdapterFactory())
    }.build()
}

fun getMatchAdapter(): JsonAdapter<Match> {
    return getMoshi().adapter(Match::class.java)
}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder().apply {
        baseUrl(Constants.GAMES_BASE_URL)
        client(httpClient())
        addConverterFactory(MoshiConverterFactory.create(getMoshi()))
    }.build()
}

private inline fun <reified T> retrofitService(): T = getRetrofit().create(T::class.java)