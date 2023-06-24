package com.exfarnanda1945.netdemymvvm.api

import com.exfarnanda1945.netdemymvvm.constant.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}