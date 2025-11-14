package com.example.applicationandroidrossivalentin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Spell(
    @SerialName("index")
    val index: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("desc")
    val desc: List<String> = emptyList(),

    @SerialName("higher_level")
    val higherLevel: List<String> = emptyList(),

    @SerialName("range")
    val range: String = "",

    @SerialName("components")
    val components: List<String> = emptyList(),

    @SerialName("material")
    val material: String? = null,

    @SerialName("ritual")
    val ritual: Boolean = false,

    @SerialName("duration")
    val duration: String = "",

    @SerialName("concentration")
    val concentration: Boolean = false,

    @SerialName("casting_time")
    val castingTime: String = "",

    @SerialName("level")
    val level: Int = 0,

    @SerialName("attack_type")
    val attackType: String? = null,

    @SerialName("damage")
    val damage: Damage? = null,

    @SerialName("area_of_effect")
    val areaOfEffect: AreaOfEffect? = null,

    @SerialName("school")
    val school: ApiReference? = null,

    @SerialName("classes")
    val classes: List<ApiReference> = emptyList(),

    @SerialName("subclasses")
    val subclasses: List<ApiReference> = emptyList(),

    @SerialName("url")
    val url: String? = null,

    @SerialName("updated_at")
    val updatedAt: String? = null
)

@Serializable
data class AreaOfEffect(
    @SerialName("type")
    val type: String = "",

    @SerialName("size")
    val size: Int = 0
)

@Serializable
data class Damage(
    @SerialName("damage_type")
    val damageType: ApiReference? = null,

    @SerialName("damage_at_slot_level")
    val damageAtSlotLevel: Map<String, String>? = null,

    @SerialName("damage_at_character_level")
    val damageAtCharacterLevel: Map<String, String>? = null
)

@Serializable
data class ApiReference(
    @SerialName("index")
    val index: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("url")
    val url: String = ""
)