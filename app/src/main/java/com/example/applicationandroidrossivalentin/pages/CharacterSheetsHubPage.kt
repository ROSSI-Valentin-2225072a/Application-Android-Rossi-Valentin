package com.example.applicationandroidrossivalentin.pages

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterSheets(onClickHome: () -> Unit) {

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
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(Icons.Filled.Add, "Create New Character")
                    }
                },

            )
        },
    ) {}
}