package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.viewmodels.SpellViewModel
import kotlinx.coroutines.launch

@Composable
fun Spells(onClickHome: () -> Unit) {

    val coroutineScope = rememberCoroutineScope()

    val viewModel = viewModel<SpellViewModel>()
    val spell = viewModel.spell.collectAsStateWithLifecycle()



    Column {
        Text("Spells")

        Button(onClick = { coroutineScope.launch{ viewModel.getSpell("acid-arrow") } }) {
            Text("get it :)")
        }

        Button(onClick = onClickHome) {
            Text("back")
        }
    }
}