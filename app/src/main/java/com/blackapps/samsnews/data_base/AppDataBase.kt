package com.blackapps.samsnews.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blackapps.samsnews.article.model.Article
import com.blackapps.samsnews.article.model.ArticlesDao

private const val DATABASE = "Database-Room"

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)


abstract class AppDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao

    companion object {

        @Volatile
        private var iInstance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = iInstance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE
                ).build()
                iInstance = instance
                return instance
            }
        }
    }
}
