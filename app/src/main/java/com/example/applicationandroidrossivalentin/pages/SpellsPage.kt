package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.composants.SpellLevelFilter
import com.example.applicationandroidrossivalentin.viewmodels.SpellViewModel

//TODO : Ajouter une barre de recherche de sorts
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spells(onClickHome: () -> Unit) {

    val viewModel = viewModel<SpellViewModel>()
    val spellList = viewModel.spellList.collectAsStateWithLifecycle()
    val sheetState = rememberModalBottomSheetState()
    val spellShown = viewModel.spell.collectAsStateWithLifecycle()

    var showBottomSheet by remember { mutableStateOf(false) }
    var expandedDropdown by remember { mutableStateOf(false) }
    var selectedLevels by remember { mutableStateOf(setOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)) }


    Scaffold (topBar = {
        TopAppBar(
            title = { Text("Spells") },
            navigationIcon = {
                IconButton(onClick = onClickHome) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back to menu",
                    )
                }
            },
            actions = {
                SpellLevelFilter(
                    selectedLevels,
                    {selectedLevels = it},
                )

            }

        )
    }, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(spellList.value) { spell ->
                    ListItem(
                        headlineContent = { Text(spell.name) },
                        supportingContent = { Text("Level ${spell.level}") },
                        modifier = Modifier.clickable(onClick = {
                            showBottomSheet = true
                            viewModel.getSpell(spell.index)
                        })
                    )
                    HorizontalDivider()
                }
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState
                ) {
                    Text(spellShown.value.name)
                }
            }
        }
    }
}