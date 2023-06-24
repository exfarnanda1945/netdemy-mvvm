package com.exfarnanda1945.netdemymvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exfarnanda1945.netdemymvvm.model.ArticlesItem
import com.exfarnanda1945.netdemymvvm.databinding.NewsItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MainViewHolder>() {
    private var articleItems = listOf<ArticlesItem?>()

    inner class MainViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticlesItem) {
            Glide.with(binding.root).load(article.urlToImage).into(binding.imgNews)
            binding.newsTitle.text = article.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return articleItems.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val article = articleItems[position]!!
        holder.bind(article)
    }

    fun setData(data: List<ArticlesItem?>) {
        articleItems = data
    }
}