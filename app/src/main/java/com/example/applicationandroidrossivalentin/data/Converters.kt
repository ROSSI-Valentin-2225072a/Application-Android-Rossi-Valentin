package com.example.applicationandroidrossivalentin.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.applicationandroidrossivalentin.models.CharacterClass
import com.example.applicationandroidrossivalentin.models.Race
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class Converters(moshi: Moshi) {

    private val listStringType = Types.newParameterizedType(List::class.java, String::class.java)
    private val listJsonAdapter = moshi.adapter<List<String>>(listStringType)
    private val raceAdapter = moshi.adapter(Race::class.java)
    private val characterClassAdapter = moshi.adapter(CharacterClass::class.java)

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.let { listJsonAdapter.toJson(it) }
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return value?.let { listJsonAdapter.fromJson(it) }
    }

    @TypeConverter
    fun fromRace(race: Race?): String? {
        return race?.let { raceAdapter.toJson(it) }
    }

    @TypeConverter
    fun toRace(value: String?): Race? {
        return value?.let { raceAdapter.fromJson(it) }
    }

    @TypeConverter
    fun fromCharacterClass(characterClass: CharacterClass?): String? {
        return characterClass?.let { characterClassAdapter.toJson(it) }
    }

    @TypeConverter
    fun toCharacterClass(value: String?): CharacterClass? {
        return value?.let { characterClassAdapter.fromJson(it) }
    }
}