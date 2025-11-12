package com.example.applicationandroidrossivalentin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.applicationandroidrossivalentin.pages.CharacterSheets
import com.example.applicationandroidrossivalentin.pages.Classes
import com.example.applicationandroidrossivalentin.pages.Home
import com.example.applicationandroidrossivalentin.pages.Races
import com.example.applicationandroidrossivalentin.pages.Spells
import com.example.applicationandroidrossivalentin.ui.theme.AppliDND

class DestinationHome
class DestinationCharacterSheets
class DestinationSpells
class DestinationClasses
class DestinationRaces


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppliDND {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) { // TODO : remplacer par des boutons

    val backStack = remember { mutableStateListOf<Any>(DestinationHome()) }

    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                entryProvider = { key ->
                    when ( key ) {
                        is DestinationHome -> NavEntry(key) {
                            Home(
                                onClickCharacterSheets = {
                                backStack.add(DestinationCharacterSheets())
                            }, onClickSpells = {
                                backStack.add(DestinationSpells())
                            }, onClickClasses = {
                                backStack.add(DestinationClasses())
                            }, onClickRaces = {
                                backStack.add(DestinationRaces())
                            })
                        }
                        is DestinationCharacterSheets -> NavEntry(key) {
                            CharacterSheets(onClickHome = {
                                backStack.removeLastOrNull()
                            })
                        }
                        is DestinationSpells -> NavEntry(key) {
                            Spells(onClickHome = {
                                backStack.removeLastOrNull()

                            })
                        }
                        is DestinationClasses -> NavEntry(key) {
                            Classes(onClickHome = {
                                backStack.removeLastOrNull()
                            })
                        }
                        is DestinationRaces -> NavEntry(key) {
                            Races(onClickHome = {
                                backStack.removeLastOrNull()
                            })
                        }
                        else -> throw IllegalArgumentException("Unknown key: $key")
                    }
                }
            )
        }
    }
}

