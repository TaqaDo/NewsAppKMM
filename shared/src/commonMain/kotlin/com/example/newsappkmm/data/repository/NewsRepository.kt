package com.example.newsappkmm.data.repository

import com.example.newsappkmm.data.source.remote.INewsRemoteDataSource
import com.example.newsappkmm.models.NewsResponse
import com.example.newsappkmm.utils.Response

class NewsRepository(
    private val newsDataSource: INewsRemoteDataSource
) {
    suspend fun getBreakingNews(): Response<NewsResponse> {
        return newsDataSource.getBreakingNews()
    }
}