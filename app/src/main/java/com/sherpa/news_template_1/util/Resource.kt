package com.sherpa.news_template_1.util

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
sealed class Resource<T> (
    val data : T? = null,
    val message : String? = null
) {

    class Success<T>(data : T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data,message)
    class Loading<T>: Resource<T>()

}

