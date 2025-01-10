package com.sherpa.news_template_1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sherpa.news_template_1.model.Article
import com.sherpa.news_template_1.model.NewsResponse
import com.sherpa.news_template_1.repository.NewsRepository
import com.sherpa.news_template_1.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
class NewsViewModel
    (private val newsRepository: NewsRepository) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsNumber = 1
    var breakingNewsResponse: NewsResponse? = null

    val localNewsList =  MutableLiveData<List<Article>>()
    init {
        getBreakingNews("us")
    }


    fun getBreakingNews(countryCode: String) = viewModelScope.launch{

        breakingNews.postValue(Resource.Loading())

        val response = newsRepository.getBreakingNews(countryCode, breakingNewsNumber)
        breakingNews.postValue(handleBreakingNews(response))

    }


    fun handleBreakingNews(response: Response<NewsResponse>) : Resource<NewsResponse>{

        if(response.isSuccessful){
            response.body()?.let { resultResponse ->

                breakingNewsNumber++
                if(breakingNewsResponse == null){
                    breakingNewsResponse = resultResponse
                }else{
                    val oldArticles = breakingNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }


                return Resource.Success(breakingNewsResponse ?: resultResponse)

            }
        }

        return Resource.Error(response.message())
    }


    fun getNewsFromLocalDb() = newsRepository.getSavedNews()

}