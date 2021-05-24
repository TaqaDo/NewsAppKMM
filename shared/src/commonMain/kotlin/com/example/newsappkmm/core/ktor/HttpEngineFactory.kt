package com.example.newsappkmm.core.ktor

import io.ktor.client.engine.*

expect class HttpEngineFactory constructor() {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}