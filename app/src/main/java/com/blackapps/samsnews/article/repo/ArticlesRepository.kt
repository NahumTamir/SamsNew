package com.blackapps.samsnews.article.repo

import androidx.lifecycle.LiveData
import com.blackapps.samsnews.article.model.Article
import com.blackapps.samsnews.article.model.ArticlesDao
import com.blackapps.samsnews.article.model.Source
import com.blackapps.samsnews.article.model.Sources
import com.blackapps.samsnews.article.news_api.GetNews
import java.io.IOException
import java.util.concurrent.Executors

class ArticlesRepository(private var articlesDao: ArticlesDao) {

    private val executorService = Executors.newSingleThreadExecutor()

    init {
        updateRepoFromRemote()
    }

    private fun updateRepoFromRemote() {
        executorService.execute {
            try {
                for (source in Sources.sources) {
                    //Fetch from server
                    val serverArticles = GetNews(source).getArticles()

                    // Transform server object to model
                    val articles = mutableListOf<Article>()
                    for (sArticle in serverArticles) {
                        val article = Article(
                            0,
                            sArticle.author,
                            sArticle.content,
                            sArticle.description,
                            sArticle.publishedAt,
                            sArticle.serverSource.name,
                            sArticle.title,
                            sArticle.url,
                            sArticle.urlToImage
                        )
                        articles.add(article)
                    }



                    // Save to DB
                    articlesDao.insertAllArticles(articles)
                }
            } catch (e: IOException) {
                // We should print log here
                e.printStackTrace()
            }
        }
    }

    fun getNews(source: Source): LiveData<List<Article>> {
        return articlesDao.getArticles(source.name)
    }
}
