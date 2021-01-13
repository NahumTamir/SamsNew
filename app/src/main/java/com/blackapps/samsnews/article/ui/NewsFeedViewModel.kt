package com.blackapps.samsnews.article.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.blackapps.samsnews.MainApplication
import com.blackapps.samsnews.article.model.Article
import com.blackapps.samsnews.article.model.Source
import com.blackapps.samsnews.article.repo.ArticlesRepository
import com.blackapps.samsnews.data_base.AppDatabase


class NewsFeedViewModel : ViewModel() {

    private val articlesRepository: ArticlesRepository =
        ArticlesRepository(AppDatabase.getDatabase(MainApplication.appContext!!).articlesDao())

    fun getArticles(source: Source): LiveData<List<Article>> {
        return articlesRepository.getNews(source)
    }
}