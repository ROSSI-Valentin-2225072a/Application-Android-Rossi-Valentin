package com.example.applicationandroidrossivalentin.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi

@ProvidedTypeConverter
class Converters(moshi: Moshi) {
    private val listJsonAdapter = moshi.adapter<List<String>>(List::class.java)


    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return listJsonAdapter.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String>? {
        return listJsonAdapter.fromJson(value)
    }
}