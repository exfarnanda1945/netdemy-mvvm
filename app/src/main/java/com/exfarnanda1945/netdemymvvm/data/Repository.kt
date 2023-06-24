package com.exfarnanda1945.netdemymvvm.data

import com.exfarnanda1945.netdemymvvm.api.NewsApi
import com.exfarnanda1945.netdemymvvm.model.NewsResponse
import retrofit2.Call

class Repository(private val api:NewsApi) {
    fun getNews(): Call<NewsResponse> =api.listNews()
}