package com.blackapps.samsnews.article.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blackapps.samsnews.article.model.Article
@Dao
interface ArticlesDao {

    @Query("SELECT * FROM article_table WHERE source = :source")
    fun getArticles(source: String): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArticles(articles: List<Article>?)

    @Query("DELETE FROM article_table")
    fun deleteAllArticles()

}