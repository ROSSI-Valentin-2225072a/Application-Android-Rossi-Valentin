package com.example.applicationandroidrossivalentin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Race(
    @SerialName("index")
    val index: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("speed")
    val speed: Int = 0,

    @SerialName("ability_bonuses")
    val abilityBonuses: AbilityBonuses = AbilityBonuses(),

    @SerialName("age")
    val age: String = "",

    @SerialName("alignment")
    val alignment: String = "",

    @SerialName("size")
    val size: String = "",

    @SerialName("size_description")
    val sizeDescription: String = "",

    @SerialName("languages")
    val languages: List<Reference> = emptyList(),

    @SerialName("language_desc")
    val languageDesc: String = "",

    @SerialName("traits")
    val traits: List<Reference> = emptyList(),

    @SerialName("subraces")
    val subraces: List<Reference> = emptyList()
)

@Serializable
data class AbilityBonuses(
    @SerialName("ability_score")
    val abilityScore: Reference = Reference(),

    @SerialName("bonus")
    val bonus: Int = 0,
)

@Serializable
data class Races(
    val count: Int = 0,
    val results: List<Race> = emptyList()
)