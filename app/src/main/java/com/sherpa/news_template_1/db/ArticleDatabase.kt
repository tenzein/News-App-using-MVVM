package com.sherpa.news_template_1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sherpa.news_template_1.model.Article

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
@Database(
    entities = [Article::class],
    version = 1
)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun getArticleDao(): ArticleDao

    companion object{

        @Volatile
        private var instance : ArticleDatabase ?= null
        private val LOCK = Any()

        operator fun invoke(context: Context) =  instance?: synchronized(LOCK){
            instance ?: createDatabse(context).also { instance = it}
        }

        private fun createDatabse(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ArticleDatabase::class.java,
            "article_db.db"
        ).build()

    }
}