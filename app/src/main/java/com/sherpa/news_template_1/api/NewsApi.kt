package com.sherpa.news_template_1.api

import com.sherpa.news_template_1.model.NewsResponse
import com.sherpa.news_template_1.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode : String = "us",
        @Query("page") pageNumber : Int = 1,
        @Query("apiKey") apiKey : String = API_KEY
    ) : Response<NewsResponse>


    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery : String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>


}