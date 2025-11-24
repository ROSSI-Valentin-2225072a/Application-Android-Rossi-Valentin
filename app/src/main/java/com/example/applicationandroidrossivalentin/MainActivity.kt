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
import com.example.applicationandroidrossivalentin.pages.CharacterClasses
import com.example.applicationandroidrossivalentin.pages.CharacterSheetPage
import com.example.applicationandroidrossivalentin.pages.CharacterSheets
import com.example.applicationandroidrossivalentin.pages.CharacterSheetsCreationPage
import com.example.applicationandroidrossivalentin.pages.Home
import com.example.applicationandroidrossivalentin.pages.Races
import com.example.applicationandroidrossivalentin.pages.Spells
import com.example.applicationandroidrossivalentin.ui.theme.AppliDND

class DestinationHome
class DestinationCharacterSheets
class DestinationSpells
class DestinationCharacterClasses
class DestinationRaces
class DestinationCharacterSheetsCreation
class DestinationCharacterSheetDetail(val characterId: Int)

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
fun Main(modifier: Modifier = Modifier) {

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
                            }, onClickCharacterClasses = {
                                backStack.add(DestinationCharacterClasses())
                            }, onClickRaces = {
                                backStack.add(DestinationRaces())
                            })
                        }
                        is DestinationCharacterSheets -> NavEntry(key) {
                            CharacterSheets(
                                onClickHome = { backStack.removeLastOrNull() },
                                onClickCreate = { backStack.add(DestinationCharacterSheetsCreation()) },
                                onClickCharacter = { characterId ->
                                    backStack.add(DestinationCharacterSheetDetail(characterId))
                                }
                            )
                        }
                        is DestinationSpells -> NavEntry(key) {
                            Spells(onClickHome = {
                                backStack.removeLastOrNull()

                            })
                        }
                        is DestinationCharacterClasses -> NavEntry(key) {
                            CharacterClasses(onClickHome = {
                                backStack.removeLastOrNull()
                            })
                        }
                        is DestinationRaces -> NavEntry(key) {
                            Races(onClickHome = {
                                backStack.removeLastOrNull()
                            })
                        }
                        is DestinationCharacterSheetsCreation -> NavEntry(key) {
                            CharacterSheetsCreationPage(onClickBackToHub = {
                                backStack.removeLastOrNull()
                            })
                        }
                        is DestinationCharacterSheetDetail -> NavEntry(key) {
                            CharacterSheetPage(
                                characterId = key.characterId,
                                onClickBack = { backStack.removeLastOrNull() }
                            )
                        }
                        else -> throw IllegalArgumentException("Unknown key: $key")
                    }
                }
            )
        }
    }
}

