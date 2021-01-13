package com.blackapps.samsnews.article.news_api

import android.util.Log
import com.blackapps.samsnews.article.model.Article
import com.blackapps.samsnews.article.model.Source
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetNews(private val source: Source) {

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    private val newsApi: NewsAPI
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsApi = retrofit.create(NewsAPI::class.java)
    }

    fun getArticles(): List<ServerArticle> {
        return newsApi.getArticles(source.name).execute().body()?.serverArticles ?: listOf()
    }
}