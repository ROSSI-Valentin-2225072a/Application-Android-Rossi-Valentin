package com.example.applicationandroidrossivalentin.repositories

import android.util.Log
import com.example.applicationandroidrossivalentin.models.ApiReference
import com.example.applicationandroidrossivalentin.models.Spell
import com.example.applicationandroidrossivalentin.models.Spells
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json

class SpellRepository {

    val url = "https://www.dnd5eapi.co/api/2014/spells"
    val client = HttpClient(CIO) {
        install(ContentNegotiation){
            json()
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d("Ktor-Logger", message)
                }
            }
        }
    }

    suspend fun getSpell(index: String) : Spell {
        return client.get("$url/$index").body()
    }

    suspend fun getAllSpell() : Spells {
        return client.get(url).body()
    }

    suspend fun getFilteredSpells(levels: List<Int>, schools: List<String>): Spells {
        val filterParams = buildString {
            levels.forEach { append("level=$it&") }
            schools.forEach { append("school=$it&") }
        }.dropLast(1)

        return client.get("$url?$filterParams").body()
    }
}