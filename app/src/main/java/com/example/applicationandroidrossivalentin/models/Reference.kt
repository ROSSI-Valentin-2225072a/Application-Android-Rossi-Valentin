package com.example.applicationandroidrossivalentin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reference(
    @SerialName("index")
    val index: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("url")
    val url: String = ""
)