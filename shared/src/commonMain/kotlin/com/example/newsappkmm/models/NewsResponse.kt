package com.example.newsappkmm.models

import kotlinx.serialization.Serializable


@Serializable
data class NewsResponse(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Article>? = null
)

@Serializable
data class Article(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
)

@Serializable
data class Source(
    val id: String? = null,
    val name: String? = null,
)
