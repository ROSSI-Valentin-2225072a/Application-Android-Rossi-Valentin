package com.example.applicationandroidrossivalentin.repositories

import android.util.Log
import com.example.applicationandroidrossivalentin.models.Race
import com.example.applicationandroidrossivalentin.models.Races
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class RaceRepository {

    val url = "https://www.dnd5eapi.co/api/2014/races"
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

    suspend fun getAllRaces(): Races {
        return client.get(url).body()
    }

    suspend fun getRaceByIndex(index: String): Race {
        return client.get("$url/$index").body()
    }

}