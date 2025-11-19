package com.example.applicationandroidrossivalentin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterClass(
    @SerialName("index")
    val index: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("hit_die")
    val hitDie: Int = 0,

    @SerialName("proficiency_choices")
    val proficiencyChoices: List<ProficiencyChoice> = emptyList(),

    @SerialName("proficiencies")
    val proficiencies: List<Reference> = emptyList(),

    @SerialName("saving_throws")
    val savingThrows: List<Reference> = emptyList(),

    @SerialName("starting_equipment")
    val startingEquipment: List<Equipment> = emptyList(),

    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: List<EquipmentOption> = emptyList(),

    @SerialName("class_levels")
    val classLevels: String = "",

    @SerialName("multi_classing")
    val multiClassing: MultiClassing = MultiClassing(),

    @SerialName("subclasses")
    val subclasses: List<Reference> = emptyList(),

    @SerialName("url")
    val url: String = "",

    @SerialName("updated_at")
    val updatedAt: String = ""
)

@Serializable
data class ProficiencyChoice(
    @SerialName("desc")
    val desc: String = "",

    @SerialName("choose")
    val choose: Int = 0,

    @SerialName("type")
    val type: String = "",

    @SerialName("from")
    val from: OptionSet = OptionSet()
)

@Serializable
data class OptionSet(
    @SerialName("option_set_type")
    val optionSetType: String = "",

    @SerialName("options")
    val options: List<Option>? = null,

    @SerialName("equipment_category")
    val equipmentCategory: Reference? = null
)

@Serializable
data class Option(
    @SerialName("option_type")
    val optionType: String = "",

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
    val index: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("url")
    val url: String = ""
)

@Serializable
data class Equipment(
    @SerialName("equipment")
    val equipment: Reference = Reference(),

    @SerialName("quantity")
    val quantity: Int = 0
)

@Serializable
data class EquipmentOption(
    @SerialName("desc")
    val desc: String = "",

    @SerialName("choose")
    val choose: Int = 0,

    @SerialName("type")
    val type: String = "",

    @SerialName("from")
    val from: OptionSet = OptionSet()
)

@Serializable
data class EquipmentChoice(
    @SerialName("desc")
    val desc: String = "",

    @SerialName("choose")
    val choose: Int = 0,

    @SerialName("type")
    val type: String = "",

    @SerialName("from")
    val from: OptionSet = OptionSet()
)

@Serializable
data class MultiClassing(
    @SerialName("prerequisites")
    val prerequisites: List<Prerequisite> = emptyList(),

    @SerialName("proficiencies")
    val proficiencies: List<Reference> = emptyList()
)

@Serializable
data class Prerequisite(
    @SerialName("ability_score")
    val abilityScore: Reference = Reference(),

    @SerialName("minimum_score")
    val minimumScore: Int = 0
)

@Serializable
data class CharacterClasses(
    val count: Int = 0,
    val results: List<CharacterClass> = emptyList()
)