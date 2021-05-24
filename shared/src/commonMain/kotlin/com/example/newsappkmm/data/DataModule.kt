package com.example.newsappkmm.data

import com.example.newsappkmm.data.repository.NewsRepository
import com.example.newsappkmm.data.source.remote.INewsRemoteDataSource
import com.example.newsappkmm.data.source.remote.NewsRemoteDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val dataModule = DI.Module(
    name = "DataModule",
    init = {
        bind<INewsRemoteDataSource>() with singleton { NewsRemoteDataSource(
            httpClient = instance(),
            json = instance()
        ) }

        bind<NewsRepository>() with singleton { NewsRepository(
            newsDataSource = instance()
        ) }
    }
)