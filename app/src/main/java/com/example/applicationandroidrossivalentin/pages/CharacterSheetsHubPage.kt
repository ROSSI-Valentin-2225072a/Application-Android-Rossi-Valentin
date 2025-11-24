package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.viewmodels.CharacterSheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterSheets(
    onClickHome: () -> Unit,
    onClickCreate: () -> Unit
    ) {

    val viewModel = viewModel<CharacterSheetViewModel>()
    val characterSheetList = viewModel.characterSheetList.collectAsStateWithLifecycle()
    val characterSheet = viewModel.characterSheet.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Characters") },
                navigationIcon = {
                    IconButton(onClick = onClickHome) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Back to menu",
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = onClickCreate,
                    ) {
                        Icon(Icons.Filled.Add, "Create New Character")
                    }
                },

            )
        },
    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(characterSheetList.value) { sheet ->
                    ListItem(
                        headlineContent = { Text(sheet.name) },

                    )
                }
            }
        }
    }
}