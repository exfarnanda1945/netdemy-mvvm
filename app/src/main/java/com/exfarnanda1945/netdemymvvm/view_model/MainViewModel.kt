package com.exfarnanda1945.netdemymvvm.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exfarnanda1945.netdemymvvm.api.ApiConfig
import com.exfarnanda1945.netdemymvvm.data.Repository
import com.exfarnanda1945.netdemymvvm.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val api by lazy { ApiConfig.api }
    private val repository by lazy { Repository(api) }

    private var _uiState = MutableLiveData(UiState())
    val uiState = _uiState

    init {
        getListNews()
    }

    private fun getListNews() {
        repository.getNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                if (response.body() != null) {
                    _uiState.value =
                        UiState(isLoading = false, data = response.body()?.articles!!)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                _uiState.value = UiState(error = t.localizedMessage!!, isLoading = false)
            }
        })
    }
}