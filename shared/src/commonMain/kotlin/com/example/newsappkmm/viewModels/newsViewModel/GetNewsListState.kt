package com.example.newsappkmm.viewModels.newsViewModel

import com.example.newsappkmm.models.NewsResponse
import com.example.newsappkmm.utils.Response

sealed class GetNewsListState {
    abstract val response: Response<NewsResponse>?
}

data class SuccessNewsListState(override val response: Response<NewsResponse>) : GetNewsListState()
data class LoadingNewsListState(override val response: Response<NewsResponse>? = null) : GetNewsListState()
data class ErrorNewsListState(override val response: Response<NewsResponse>) : GetNewsListState()