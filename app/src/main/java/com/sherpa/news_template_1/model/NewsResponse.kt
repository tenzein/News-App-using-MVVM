package com.sherpa.news_template_1.model


data class NewsResponse(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)