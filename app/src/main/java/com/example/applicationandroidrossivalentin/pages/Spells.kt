package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Spells(onClickHome: () -> Unit) {

    Column {
        Text("Spells")

        Button(onClick = onClickHome) {
            Text("back")
        }
    }
}