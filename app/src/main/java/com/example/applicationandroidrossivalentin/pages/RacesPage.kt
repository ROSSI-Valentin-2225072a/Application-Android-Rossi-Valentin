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
import com.example.applicationandroidrossivalentin.viewmodels.RaceViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Races(onClickHome: () -> Unit) {

    val viewModel = viewModel<RaceViewModel>()
    val raceList = viewModel.raceList.collectAsStateWithLifecycle()
    val race = viewModel.race.collectAsStateWithLifecycle()
    val sheetState = rememberModalBottomSheetState()

    var showBottomSheet by remember { mutableStateOf(false) }


    Scaffold (topBar = {
        TopAppBar(
            title = { Text("Races") },
            navigationIcon = {
                IconButton(onClick = onClickHome) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back to menu",
                    )
                }
            },
            actions = {


            }

        )
    }, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(raceList.value) { race ->
                    ListItem(
                        headlineContent = { Text(race.name) },
                        // supportingContent = { Text("Level ${race.level}") },
                        modifier = Modifier.clickable(onClick = {
                            showBottomSheet = true
                            viewModel.getRaceByIndex(race.index)
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
                    Text(race.value.name)
                }
            }
        }
    }
}