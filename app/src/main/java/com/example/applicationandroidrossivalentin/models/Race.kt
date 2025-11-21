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
    val abilityBonuses: List<AbilityBonuses> = emptyList(),

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

    @SerialName("language_options")
    val languageOptions: LanguageOptions? = LanguageOptions(),


    @SerialName("language_desc")
    val languageDesc: String = "",

    @SerialName("traits")
    val traits: List<Reference> = emptyList(),

    @SerialName("subraces")
    val subraces: List<Reference> = emptyList(),

    @SerialName("url")
    val url: String = "",

    @SerialName("updated_at")
    val updatedAt: String = "",
)

@Serializable
data class AbilityBonuses(
    @SerialName("ability_score")
    val abilityScore: Reference? = null,

    @SerialName("bonus")
    val bonus: Int = 0,
)

@Serializable
data class LanguageOptions(
    @SerialName("choose")
    val choose: Int = 0,

    @SerialName("type")
    val type: String = "",

    @SerialName("from")
    val from: From = From(),
)

@Serializable
data class From(
    @SerialName("option_set_type")
    val optionsSetType: String = "",

    @SerialName("options")
    val options: List<OptionLanguage> = emptyList(),
)

@Serializable
data class OptionLanguage(
    @SerialName("option_type")
    val optionType: String = "",

    @SerialName("item")
    val item: Reference? = null
)

@Serializable
data class Races(
    val count: Int = 0,
    val results: List<Race> = emptyList()
)