package com.exfarnanda1945.netdemymvvm.view_model

import com.exfarnanda1945.netdemymvvm.model.ArticlesItem

data class UiState(
    val error: String = "",
    val isLoading: Boolean = true,
    val data: List<ArticlesItem?> = listOf()
)
