package com.example.newsappkmm.android

import android.app.Application
import com.example.newsappkmm.di.Configuration
import com.example.newsappkmm.di.NewsAppSDK
import com.example.newsappkmm.di.PlatformType

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        NewsAppSDK.init(Configuration(platformType = PlatformType.Android("1.1", "1.1")))
    }
}