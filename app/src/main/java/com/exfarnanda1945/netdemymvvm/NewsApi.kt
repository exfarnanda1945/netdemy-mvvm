package com.exfarnanda1945.netdemymvvm

import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("top-headlines?country=us&category=business&apiKey=f044de69086e45198f8406be2094a229")
    fun listNews(): Call<NewsResponse>
}