package com.example.newsappkmm.core.ktor

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val ktorModule = DI.Module(
    name = "KtorModule",
    init = {
        bind<HttpEngineFactory>() with singleton { HttpEngineFactory() }
        bind<HttpClient>() with singleton {
            val engine = instance<HttpEngineFactory>().createEngine()
            HttpClient(engine) {
                install(Logging) {
                    level = LogLevel.ALL
                    logger = Logger.SIMPLE
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
                defaultRequest {
                    host = "newsapi.org"
                    url {
                        protocol = URLProtocol.HTTPS
                    }
                }
            }

        }
    }
)