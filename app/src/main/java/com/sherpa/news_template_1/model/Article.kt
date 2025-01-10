package com.sherpa.news_template_1.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sherpa.news_template_1.db.Converters


@Entity(
    tableName = "articles"
)
@TypeConverters(Converters::class)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : java.io.Serializable