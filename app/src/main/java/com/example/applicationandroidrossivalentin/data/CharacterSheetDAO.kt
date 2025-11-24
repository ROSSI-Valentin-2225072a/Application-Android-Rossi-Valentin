package com.example.applicationandroidrossivalentin.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.applicationandroidrossivalentin.entities.CharacterSheetEntity

@Dao
interface CharacterSheetDAO {

    // CREATE
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(character: CharacterSheetEntity): Long

    // READ
    @Query("SELECT * FROM character_sheets ORDER BY updatedAt ASC")
    suspend fun getAll(): List<CharacterSheetEntity>

    @Query("SELECT * FROM character_sheets WHERE id = :characterId")
    suspend fun getById(characterId: Int): CharacterSheetEntity

    @Query("SELECT * FROM character_sheets WHERE name LIKE '%' || :searchQuery || '%' ORDER BY name ASC")
    suspend fun searchByName(searchQuery: String): List<CharacterSheetEntity>

    @Query("SELECT * FROM character_sheets WHERE characterClass = :className ORDER BY name ASC")
    suspend fun getByClass(className: String): List<CharacterSheetEntity>

    @Query("SELECT * FROM character_sheets WHERE level >= :minLevel AND level <= :maxLevel ORDER BY level DESC")
    suspend fun getByLevelRange(minLevel: Int, maxLevel: Int): List<CharacterSheetEntity>

    @Query("SELECT COUNT(*) FROM character_sheets")
    suspend fun getCount(): Int

    // UPDATE
    @Update
    suspend fun update(character: CharacterSheetEntity)

    @Query("UPDATE character_sheets SET currentHitPoints = :newHp WHERE id = :characterId")
    suspend fun updateCurrentHp(characterId: Int, newHp: Int)

    @Query("UPDATE character_sheets SET experiencePoints = :newXp WHERE id = :characterId")
    suspend fun updateXp(characterId: Int, newXp: Int)

    @Query("UPDATE character_sheets SET level = :newLevel WHERE id = :characterId")
    suspend fun updateLevel(characterId: Int, newLevel: Int)

    @Query("UPDATE character_sheets SET updatedAt = :timestamp WHERE id = :characterId")
    suspend fun updateTimestamp(characterId: Int, timestamp: Long = System.currentTimeMillis())

    // DELETE
    @Delete
    suspend fun delete(character: CharacterSheetEntity)

    @Query("DELETE FROM character_sheets WHERE id = :characterId")
    suspend fun deleteById(characterId: Int)

}