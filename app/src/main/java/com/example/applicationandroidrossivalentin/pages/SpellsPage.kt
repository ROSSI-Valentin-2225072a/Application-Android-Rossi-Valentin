package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.viewmodels.SpellViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spells(onClickHome: () -> Unit) {

    val viewModel = viewModel<SpellViewModel>()
    val spellList = viewModel.spellList.collectAsStateWithLifecycle()

    Scaffold (topBar = {
        TopAppBar(
            title = { Text("Spells") },
            navigationIcon = {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Burger")
            },
            actions = {

            }
        )
    },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(spellList.value) { spell ->
                    ListItem(
                        headlineContent = { Text(spell.name) },
                        supportingContent = { Text("Level ${spell.level}") },
                        trailingContent = {
                            Icon(Icons.Default.MoreVert, contentDescription = null)
                        }
                    )
                    HorizontalDivider()
                }
            }
            Button(onClick = onClickHome) {
                Text("back")
            }
        }
    }
}