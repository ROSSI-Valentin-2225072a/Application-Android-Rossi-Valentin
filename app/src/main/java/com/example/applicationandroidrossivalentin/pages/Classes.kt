package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Classes(onClickHome: () -> Unit) {

    Column {
        Text("Classes")

        Button(onClick = onClickHome) {
            Text("back")
        }
    }
}