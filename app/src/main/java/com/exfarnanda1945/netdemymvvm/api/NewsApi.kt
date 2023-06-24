package com.exfarnanda1945.netdemymvvm.api

import com.exfarnanda1945.netdemymvvm.constant.Constant.API_KEY
import com.exfarnanda1945.netdemymvvm.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("top-headlines?country=us&category=business&apiKey=${API_KEY}")
    fun listNews(): Call<NewsResponse>
}