package com.sherpa.news_template_1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sherpa.news_template_1.model.Article

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun upsertArticles(article: Article) : Long

    @Query("SELECT * from articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}