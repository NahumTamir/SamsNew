package com.blackapps.samsnews.article.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "article_table", indices = [Index(value = ["author", "title"], unique = true)])
data class Article(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "author")
    var author: String?,

    @ColumnInfo(name = "content")
    var content: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String?,

    @ColumnInfo(name = "source")
    var source: String?,

    @ColumnInfo(name = "title")

    var title: String?,

    @ColumnInfo(name = "url")
    var url: String?,

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String?
)
