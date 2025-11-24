package com.example.applicationandroidrossivalentin.repositories

import android.content.Context
import androidx.room.Room
import com.example.applicationandroidrossivalentin.data.AppDatabase
import com.example.applicationandroidrossivalentin.data.Converters
import com.example.applicationandroidrossivalentin.entities.CharacterSheetEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class CharacterSheetRepository(context: Context) {

    val database = Room.databaseBuilder( context, AppDatabase::class.java, "character-sheet-database" )
        .addTypeConverter(Converters(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
        .build()

    val characterSheetDao = database.characterSheetDao()

    suspend fun getAllCharacterSheets(): List<CharacterSheetEntity> {
        return characterSheetDao.getAll()
    }

    suspend fun insertCharacterSheet(characterSheet: CharacterSheetEntity) {
        characterSheetDao.insert(characterSheet)
    }

    suspend fun deleteCharacterSheet(characterSheet: CharacterSheetEntity) {
        characterSheetDao.delete(characterSheet)
    }

    suspend fun deleteCharacterById(id: Int) {
        characterSheetDao.deleteById(id)
    }

    suspend fun updateCharacterSheet(characterSheet: CharacterSheetEntity) {
        characterSheetDao.update(characterSheet)
    }

    suspend fun getCharacterSheetById(id: Int): CharacterSheetEntity {
        return characterSheetDao.getById(id)
    }

    suspend fun updateCharacterHP(id: Int, hp: Int) {
        characterSheetDao.updateCurrentHp(id, hp)
    }

    suspend fun updateCharacterXp(id: Int, xp: Int) {
        characterSheetDao.updateXp(id, xp)
    }

    suspend fun updateCharacterLevel(id: Int, level: Int) {
        characterSheetDao.updateLevel(id, level)
    }

}