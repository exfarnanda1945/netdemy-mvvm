package com.exfarnanda1945.netdemymvvm.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,
)

data class ArticlesItem(

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("content")
	val content: String? = null
)