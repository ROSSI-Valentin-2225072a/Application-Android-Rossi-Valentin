package com.example.applicationandroidrossivalentin.composants

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SpellLevelFilter(
    selectedLevels: Set<Int>,
    onLevelsChanged: (Set<Int>) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    TextButton (onClick = { expanded = true }) {
        Text("Level Filter")
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        (0..9).forEach { level ->
            DropdownMenuItem(
                text = {
                    Row {
                        Checkbox(
                            checked = level in selectedLevels,
                            onCheckedChange = null
                        )
                        Text(if (level == 0) "Cantrip" else "Niveau $level")
                    }
                },
                onClick = {
                    onLevelsChanged(
                        if (level in selectedLevels) selectedLevels - level
                        else selectedLevels + level
                    )
                }
            )
        }
    }
}