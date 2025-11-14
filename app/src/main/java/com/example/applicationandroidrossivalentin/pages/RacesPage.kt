package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Races(onClickHome: () -> Unit) {

    Column {
        Text("Races")

        Button(onClick = onClickHome) {
            Text("back")
        }
    }
}