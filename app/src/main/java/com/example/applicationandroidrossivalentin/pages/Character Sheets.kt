package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CharacterSheets(onClickHome: () -> Unit) {

    Column {
        Text("Les fiches perso")

        Button(onClick = onClickHome) {
            Text("back")
        }
    }
}