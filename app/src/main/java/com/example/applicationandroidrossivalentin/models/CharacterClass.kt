package com.example.applicationandroidrossivalentin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterClass(
    @SerialName("index")
    val index: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("hit_die")
    val hitDie: Int? = null,

    @SerialName("proficiency_choices")
    val proficiencyChoices: List<ProficiencyChoice>? = null,

    @SerialName("proficiencies")
    val proficiencies: List<Reference>? = null,

    @SerialName("saving_throws")
    val savingThrows: List<Reference>? = null,

    @SerialName("starting_equipment")
    val startingEquipment: List<Equipment>? = null,

    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: List<EquipmentOption>? = null,

    @SerialName("class_levels")
    val classLevels: String? = null,

    @SerialName("multi_classing")
    val multiClassing: MultiClassing? = null,

    @SerialName("subclasses")
    val subclasses: List<Reference>? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("updated_at")
    val updatedAt: String? = null
)

@Serializable
data class ProficiencyChoice(
    @SerialName("desc")
    val desc: String,

    @SerialName("choose")
    val choose: Int,

    @SerialName("type")
    val type: String,

    @SerialName("from")
    val from: OptionSet
)

@Serializable
data class OptionSet(
    @SerialName("option_set_type")
    val optionSetType: String,

    @SerialName("options")
    val options: List<Option>? = null,

    @SerialName("equipment_category")
    val equipmentCategory: Reference? = null
)

@Serializable
data class Option(
    @SerialName("option_type")
    val optionType: String,

    @SerialName("item")
    val item: Reference? = null,

    @SerialName("count")
    val count: Int? = null,

    @SerialName("of")
    val of: Reference? = null,

    @SerialName("choice")
    val choice: EquipmentChoice? = null
)

@Serializable
data class Reference(
    @SerialName("index")
    val index: String,

    @SerialName("name")
    val name: String,

    @SerialName("url")
    val url: String
)

@Serializable
data class Equipment(
    @SerialName("equipment")
    val equipment: Reference,

    @SerialName("quantity")
    val quantity: Int
)

@Serializable
data class EquipmentOption(
    @SerialName("desc")
    val desc: String,

    @SerialName("choose")
    val choose: Int,

    @SerialName("type")
    val type: String,

    @SerialName("from")
    val from: OptionSet
)

@Serializable
data class EquipmentChoice(
    @SerialName("desc")
    val desc: String,

    @SerialName("choose")
    val choose: Int,

    @SerialName("type")
    val type: String,

    @SerialName("from")
    val from: OptionSet
)

@Serializable
data class MultiClassing(
    @SerialName("prerequisites")
    val prerequisites: List<Prerequisite>,

    @SerialName("proficiencies")
    val proficiencies: List<Reference>
)

@Serializable
data class Prerequisite(
    @SerialName("ability_score")
    val abilityScore: Reference,

    @SerialName("minimum_score")
    val minimumScore: Int
)

@Serializable
data class CharacterClasses(
    val count: Int = 0,
    val results: List<CharacterClass> = listOf()
)