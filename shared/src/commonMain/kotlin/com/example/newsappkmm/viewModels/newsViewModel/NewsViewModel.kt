package com.example.newsappkmm.viewModels.newsViewModel

import com.example.newsappkmm.data.repository.NewsRepository
import com.example.newsappkmm.models.NewsResponse
import com.example.newsappkmm.utils.Response
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepository: NewsRepository
): ViewModel() {

    // LIVE-DATA

     var mNewsListLiveData = MutableLiveData<GetNewsListState>(LoadingNewsListState())


    // REQUESTS

    fun getBreakingNews() = viewModelScope.launch {
        mNewsListLiveData.postValue(LoadingNewsListState())
        val response = newsRepository.getBreakingNews()
        processNewsListResponse(response)
    }

    // PROCESS RESPONSE

    fun processNewsListResponse(response: Response<NewsResponse>) {
        if (response is Response.Success) {
            mNewsListLiveData.postValue(SuccessNewsListState(response))
        } else if (response is Response.Error) {
            mNewsListLiveData.postValue(ErrorNewsListState(response))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}