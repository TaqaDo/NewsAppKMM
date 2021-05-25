package com.example.newsappkmm.android

import androidx.lifecycle.ViewModelProvider
import com.example.newsappkmm.di.NewsAppSDK
import com.example.newsappkmm.viewModels.newsViewModel.NewsViewModel
import com.example.newsappkmm.viewModels.viewModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class ViewModelProviderFactory(): ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
        return NewsAppSDK.viewModel.newsViewModel as T
    }
}