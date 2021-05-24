package com.example.newsappkmm.data.source.remote

import com.example.newsappkmm.models.NewsResponse
import com.example.newsappkmm.utils.Response

interface INewsRemoteDataSource {
    suspend fun getBreakingNews(): Response<NewsResponse>
}