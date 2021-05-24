package com.example.newsappkmm.core.ktor

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = Ios
}