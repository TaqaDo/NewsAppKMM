package com.example.newsappkmm.viewModels

import com.example.newsappkmm.data.dataModule
import com.example.newsappkmm.di.NewsAppSDK
import com.example.newsappkmm.viewModels.newsViewModel.NewsViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import kotlin.native.concurrent.ThreadLocal

 val viewModelsModule = DI.Module(
    name = "ViewModelsModule",
    init = {
        bind<NewsViewModel>() with singleton { NewsViewModel(
            newsRepository = instance()
        ) }
    }
)

@ThreadLocal
object ViewModelsModule {
    val newsViewModel: NewsViewModel
        get() = NewsAppSDK.di.instance()
}

val NewsAppSDK.viewModel: ViewModelsModule
    get() = ViewModelsModule