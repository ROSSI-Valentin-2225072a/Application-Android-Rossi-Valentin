package com.example.applicationandroidrossivalentin.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

// import com.example.applicationandroidrossivalentin.data.converters.ListConverter

@Entity(tableName = "character_sheets")
//@TypeConverters(ListConverter::class)
data class CharacterSheetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val race: String,
    val characterClass: String,
    val level: Int = 1,
    val background: String = "",
    val alignment: String = "",
    val experiencePoints: Int = 0,

    val strength: Int = 10,
    val dexterity: Int = 10,
    val constitution: Int = 10,
    val intelligence: Int = 10,
    val wisdom: Int = 10,
    val charisma: Int = 10,

    val maxHitPoints: Int,
    val currentHitPoints: Int,
    val temporaryHitPoints: Int = 0,

    val armorClass: Int = 10,
    val initiative: Int = 0,
    val speed: Int = 30,

    val savingThrowProficiencies: List<String> = emptyList(),

    val skillProficiencies: List<String> = emptyList(),
    val skillExpertises: List<String> = emptyList(),

    val proficiencyBonus: Int = 2,

    val spellcastingAbility: String? = null,
    val spellSaveDC: Int? = null,
    val spellAttackBonus: Int? = null,
    val knownSpells: List<String> = emptyList(),

    val spellSlotsLevel1Max: Int = 0,
    val spellSlotsLevel1Current: Int = 0,
    val spellSlotsLevel2Max: Int = 0,
    val spellSlotsLevel2Current: Int = 0,
    val spellSlotsLevel3Max: Int = 0,
    val spellSlotsLevel3Current: Int = 0,
    val spellSlotsLevel4Max: Int = 0,
    val spellSlotsLevel4Current: Int = 0,
    val spellSlotsLevel5Max: Int = 0,
    val spellSlotsLevel5Current: Int = 0,
    val spellSlotsLevel6Max: Int = 0,
    val spellSlotsLevel6Current: Int = 0,
    val spellSlotsLevel7Max: Int = 0,
    val spellSlotsLevel7Current: Int = 0,
    val spellSlotsLevel8Max: Int = 0,
    val spellSlotsLevel8Current: Int = 0,
    val spellSlotsLevel9Max: Int = 0,
    val spellSlotsLevel9Current: Int = 0,

    val equipment: List<String> = emptyList(),
    val weapons: List<String> = emptyList(),
    val armor: String? = null,

    val copperPieces: Int = 0,
    val silverPieces: Int = 0,
    val electrumPieces: Int = 0,
    val goldPieces: Int = 0,
    val platinumPieces: Int = 0,

    val features: List<String> = emptyList(),
    val traits: List<String> = emptyList(),

    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

// TypeConverter pour les listes (à placer dans un fichier séparé)
/*
package com.example.applicationandroidrossivalentin.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }
}

*/