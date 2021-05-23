package com.example.newsappkmm.di

data class Configuration(val platformType: PlatformType)

sealed class PlatformType {
    data class IOS(val version: String, val buildNumber: String): PlatformType()
    data class Android (val version: String, val buildNumber: String): PlatformType()

}