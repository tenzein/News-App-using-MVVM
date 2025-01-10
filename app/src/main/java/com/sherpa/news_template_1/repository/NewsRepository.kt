package com.sherpa.news_template_1.repository

import com.sherpa.news_template_1.api.RetrofitInstance
import com.sherpa.news_template_1.db.ArticleDatabase
import com.sherpa.news_template_1.model.Article

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
class NewsRepository(
    val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber : Int) =
        RetrofitInstance.newsApi.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery : String,pageNumber: Int) =
        RetrofitInstance.newsApi.searchForNews(searchQuery,pageNumber)

    suspend fun upsertArticle(article: Article) = db.getArticleDao().upsertArticles(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticles(article: Article)  =  db.getArticleDao().deleteArticle(article)

}