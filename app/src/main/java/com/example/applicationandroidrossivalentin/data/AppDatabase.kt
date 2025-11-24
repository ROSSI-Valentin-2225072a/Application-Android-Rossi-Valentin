package com.example.applicationandroidrossivalentin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.applicationandroidrossivalentin.entities.CharacterSheetEntity

@Database(entities = [CharacterSheetEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterSheetDao(): CharacterSheetDAO
}