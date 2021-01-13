package com.blackapps.samsnews.article.news_api

import com.google.gson.annotations.SerializedName


data class News(
    @SerializedName("articles")
    var serverArticles: List<ServerArticle>,
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int
)

data class ServerArticle(
    @SerializedName("author")
    var author: String,
    @SerializedName("content")
    var content: String,
    var description: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("source")
    var serverSource: ServerSource,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var urlToImage: String
)

data class ServerSource(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String
)