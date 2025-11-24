package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.entities.CharacterSheetEntity
import com.example.applicationandroidrossivalentin.viewmodels.CharacterSheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterSheetsCreationPage(onClickBackToHub: () -> Unit) {

    val viewModel = viewModel<CharacterSheetViewModel>()


    var name by remember { mutableStateOf("") }
    var race by remember { mutableStateOf("") }
    var characterClass by remember { mutableStateOf("") }
    var level by remember { mutableStateOf("1") }
    var background by remember { mutableStateOf("") }
    var alignment by remember { mutableStateOf("") }

    var strength by remember { mutableStateOf("10") }
    var dexterity by remember { mutableStateOf("10") }
    var constitution by remember { mutableStateOf("10") }
    var intelligence by remember { mutableStateOf("10") }
    var wisdom by remember { mutableStateOf("10") }
    var charisma by remember { mutableStateOf("10") }

    var maxHitPoints by remember { mutableStateOf("") }
    var armorClass by remember { mutableStateOf("10") }
    var speed by remember { mutableStateOf("30") }

    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create Character") },
                navigationIcon = {
                    IconButton(onClick = onClickBackToHub) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Back to menu",
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Informations de base
            Text("Basic Information", style = MaterialTheme.typography.titleLarge)

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Character Name *") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = race,
                onValueChange = { race = it },
                label = { Text("Race *") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = characterClass,
                onValueChange = { characterClass = it },
                label = { Text("Class *") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = level,
                    onValueChange = { level = it },
                    label = { Text("Level") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = background,
                    onValueChange = { background = it },
                    label = { Text("Background") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }

            OutlinedTextField(
                value = alignment,
                onValueChange = { alignment = it },
                label = { Text("Alignment") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            HorizontalDivider()

            Text("Ability Scores", style = MaterialTheme.typography.titleLarge)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = strength,
                    onValueChange = { strength = it },
                    label = { Text("STR") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = dexterity,
                    onValueChange = { dexterity = it },
                    label = { Text("DEX") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = constitution,
                    onValueChange = { constitution = it },
                    label = { Text("CON") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = intelligence,
                    onValueChange = { intelligence = it },
                    label = { Text("INT") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = wisdom,
                    onValueChange = { wisdom = it },
                    label = { Text("WIS") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = charisma,
                    onValueChange = { charisma = it },
                    label = { Text("CHA") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            }

            HorizontalDivider()

            Text("Combat Statistics", style = MaterialTheme.typography.titleLarge)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = maxHitPoints,
                    onValueChange = { maxHitPoints = it },
                    label = { Text("Max HP *") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = armorClass,
                    onValueChange = { armorClass = it },
                    label = { Text("AC") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )

                OutlinedTextField(
                    value = speed,
                    onValueChange = { speed = it },
                    label = { Text("Speed") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Bouton de création
            Button(
                onClick = {
                    // Validation
                    if (name.isBlank() || race.isBlank() || characterClass.isBlank() || maxHitPoints.isBlank()) {
                        showError = true
                        errorMessage = "Please fill all required fields (*)"
                        return@Button
                    }

                    try {
                        val character = CharacterSheetEntity(
                            name = name.trim(),
                            race = race.trim(),
                            characterClass = characterClass.trim(),
                            level = level.toIntOrNull() ?: 1,
                            background = background.trim(),
                            alignment = alignment.trim(),

                            strength = strength.toIntOrNull() ?: 10,
                            dexterity = dexterity.toIntOrNull() ?: 10,
                            constitution = constitution.toIntOrNull() ?: 10,
                            intelligence = intelligence.toIntOrNull() ?: 10,
                            wisdom = wisdom.toIntOrNull() ?: 10,
                            charisma = charisma.toIntOrNull() ?: 10,

                            maxHitPoints = maxHitPoints.toInt(),
                            currentHitPoints = maxHitPoints.toInt(),
                            armorClass = armorClass.toIntOrNull() ?: 10,
                            speed = speed.toIntOrNull() ?: 30,
                        )

                        viewModel.insertCharacterSheet(character)
                        showSuccess = true

                        onClickBackToHub()

                    } catch (e: Exception) {
                        showError = true
                        errorMessage = "Invalid input: ${e.message}"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Create Character")
            }

            // Messages d'erreur et succès
            if (showError) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Text(
                        text = errorMessage,
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }

            if (showSuccess) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Text(
                        text = "Character created successfully!",
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}