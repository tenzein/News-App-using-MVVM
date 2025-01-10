package com.sherpa.news_template_1.api

import com.sherpa.news_template_1.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
class RetrofitInstance {

    companion object {
        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)


            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()


            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }

        val newsApi  by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}