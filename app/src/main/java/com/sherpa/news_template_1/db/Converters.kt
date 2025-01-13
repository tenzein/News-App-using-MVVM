package com.sherpa.news_template_1.db

import androidx.room.TypeConverter
import com.sherpa.news_template_1.model.Source

/**
 * CREATED BY->
 * @Author: "Tenzing Sherpa"
 * @Email: "tenzingsherpaaa@gmail.com
 * @Date: 2024-12-25
 */
class Converters {

    @TypeConverter
    fun fromSource( source: Source) : String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name)
    }
}