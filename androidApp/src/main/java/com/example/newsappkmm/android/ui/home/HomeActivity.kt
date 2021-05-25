package com.example.newsappkmm.android.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappkmm.android.R
import com.example.newsappkmm.android.ViewModelProviderFactory
import com.example.newsappkmm.di.NewsAppSDK
import com.example.newsappkmm.utils.Response
import com.example.newsappkmm.viewModels.newsViewModel.*
import com.example.newsappkmm.viewModels.viewModel
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModelProviderFactory = ViewModelProviderFactory()
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        setupRecyclerView()
        observers()
        requests()
    }

    private fun requests() {
        viewModel.getBreakingNews()
    }

    private fun observers() {
        viewModel.mNewsListLiveData.addObserver { state ->
            when (state) {
                is SuccessNewsListState -> {
                    var response =  state.response as Response.Success
                    homeAdapter.differ.submitList(response.data.articles)
                }

                is LoadingNewsListState -> {
                    print("Loading")
                }

                is ErrorNewsListState -> {
                    print("Error")
                }
            }
        }
    }

    private fun setupRecyclerView() {
        homeAdapter = HomeAdapter()
        rvBreakingNews.apply {
            adapter = homeAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onCleared()
    }
}
