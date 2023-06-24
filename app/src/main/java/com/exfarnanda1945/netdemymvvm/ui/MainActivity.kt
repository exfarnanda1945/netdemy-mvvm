package com.exfarnanda1945.netdemymvvm.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.exfarnanda1945.netdemymvvm.adapter.NewsAdapter
import com.exfarnanda1945.netdemymvvm.databinding.ActivityMainBinding
import com.exfarnanda1945.netdemymvvm.view_model.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val rvAdapter by lazy {
        NewsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainViewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

        mainViewModel.uiState.observe(this@MainActivity) { uiState ->
            if (uiState.isLoading) {
                Toast.makeText(this@MainActivity, "Loading....", Toast.LENGTH_SHORT).show()
            }

            if (uiState.error.isNotEmpty()) {
                Toast.makeText(this@MainActivity, uiState.error, Toast.LENGTH_SHORT).show()
            }

            if (uiState.error.isEmpty() && uiState.data.isNotEmpty()) {
                val rv = binding.rvNews
                rvAdapter.setData(uiState.data)
                rv.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = rvAdapter
                }
            }
        }


    }
}