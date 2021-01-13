package com.blackapps.samsnews.article.news_api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    companion object {
        const val apiKey = "69548440dc944384a22fd7d0674ba5ed"
    }

    @GET( "top-headlines?-news&apiKey=$apiKey")
    fun getArticles(@Query("sources") source: String): Call<News>


//    @GET( "top-headlines?-news&apiKey=$apiKey")
//    fun getCnnArticles(@Query("sources") source: String): Call<News>
//
//    @GET( "top-headlines?-news&apiKey=$apiKey")
//    fun getCbsArticles(@Query("sources") source: String): Call<News>

}


//var url = "http://newsapi.org/v2/top-headlines?" + "sources=bbc-news&" + "apiKey=69548440dc944384a22fd7d0674ba5ed"