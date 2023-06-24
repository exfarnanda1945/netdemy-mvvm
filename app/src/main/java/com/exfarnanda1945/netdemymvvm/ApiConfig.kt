package com.exfarnanda1945.netdemymvvm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}