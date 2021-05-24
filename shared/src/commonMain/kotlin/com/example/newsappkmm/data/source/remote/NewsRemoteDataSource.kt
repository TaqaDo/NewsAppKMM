package com.example.newsappkmm.data.source.remote

import com.example.newsappkmm.models.NewsResponse
import com.example.newsappkmm.utils.Response
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class NewsRemoteDataSource(
    private val httpClient: HttpClient,
    private val json: Json
) : INewsRemoteDataSource {
    override suspend fun getBreakingNews(): Response<NewsResponse> {
        val apiKey = "575810cd32b9452c9c3a670fce22d99b"
        val httpRequest = httpClient.get<HttpStatement> {
            url {
                path("/v2/top-headlines")
                parameter("country", "us")
                header("x-api-key", apiKey)
            }
        }
        return try {
            val response = json.decodeFromString(
                (NewsResponse.serializer()),
                httpRequest.execute().readText()
            )

            Response.Success(response)
        } catch (ex: Exception) {
            Response.Error(ex)
        }
    }
}
