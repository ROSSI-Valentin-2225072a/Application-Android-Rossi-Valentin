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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.viewmodels.CharacterSheetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterSheetPage(
    characterId: Int,
    onClickBack: () -> Unit
) {
    val viewModel = viewModel<CharacterSheetViewModel>()
    val character = viewModel.characterSheet.collectAsStateWithLifecycle()
    var showDeleteDialog by remember { mutableStateOf(false) }

    LaunchedEffect(characterId) {
        viewModel.getCharacterSheetById(characterId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(character.value.name) },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Un jour ca fera quelque chose */ }) {
                        Icon(Icons.Filled.Edit, "Edit character")
                    }
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(Icons.Filled.Delete, "Delete character")
                    }
                }
            )
        }
    ) { innerPadding ->
        character.value.let { sheet ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = sheet.name,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${sheet.race?.name ?: "Unknown"} ${sheet.characterClass?.name ?: "Unknown"}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Level ${sheet.level} • ${sheet.background}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                        )
                        if (sheet.alignment.isNotEmpty()) {
                            Text(
                                text = sheet.alignment,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatCard(
                        title = "Hit Points",
                        value = "${sheet.currentHitPoints}/${sheet.maxHitPoints}",
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "AC",
                        value = sheet.armorClass.toString(),
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "Speed",
                        value = "${sheet.speed} ft",
                        modifier = Modifier.weight(1f)
                    )
                }

                Text(
                    text = "Ability Scores",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AbilityScoreCard("STR", sheet.strength, Modifier.weight(1f))
                        AbilityScoreCard("DEX", sheet.dexterity, Modifier.weight(1f))
                        AbilityScoreCard("CON", sheet.constitution, Modifier.weight(1f))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        AbilityScoreCard("INT", sheet.intelligence, Modifier.weight(1f))
                        AbilityScoreCard("WIS", sheet.wisdom, Modifier.weight(1f))
                        AbilityScoreCard("CHA", sheet.charisma, Modifier.weight(1f))
                    }
                }

                HorizontalDivider()

                Text(
                    text = "Combat",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        InfoRow("Proficiency Bonus", "+${sheet.proficiencyBonus}")
                        InfoRow("Initiative", "+${sheet.initiative}")
                        if (sheet.temporaryHitPoints > 0) {
                            InfoRow("Temporary HP", sheet.temporaryHitPoints.toString())
                        }
                    }
                }

                if (sheet.savingThrowProficiencies.isNotEmpty()) {
                    Text(
                        text = "Saving Throws",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(sheet.savingThrowProficiencies.joinToString(", "))
                        }
                    }
                }

                if (sheet.skillProficiencies.isNotEmpty()) {
                    Text(
                        text = "Skill Proficiencies",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(sheet.skillProficiencies.joinToString(", "))
                        }
                    }
                }

                if (sheet.spellcastingAbility != null) {
                    HorizontalDivider()

                    Text(
                        text = "Spellcasting",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            InfoRow("Spellcasting Ability", sheet.spellcastingAbility)
                            sheet.spellSaveDC?.let {
                                InfoRow("Spell Save DC", it.toString())
                            }
                            sheet.spellAttackBonus?.let {
                                InfoRow("Spell Attack Bonus", "+$it")
                            }
                        }
                    }

                    if (sheet.knownSpells.isNotEmpty()) {
                        Text(
                            text = "Known Spells",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(sheet.knownSpells.joinToString(", "))
                            }
                        }
                    }
                }

                HorizontalDivider()

                Text(
                    text = "Currency",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        InfoRow("Platinum", sheet.platinumPieces.toString())
                        InfoRow("Gold", sheet.goldPieces.toString())
                        InfoRow("Electrum", sheet.electrumPieces.toString())
                        InfoRow("Silver", sheet.silverPieces.toString())
                        InfoRow("Copper", sheet.copperPieces.toString())
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Character") },
            text = { Text("Are you sure you want to delete ${character.value?.name}? This action cannot be undone.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        character.value.let { viewModel.deleterCharacterSheet(it) }
                        showDeleteDialog = false
                        onClickBack()
                    }
                ) {
                    Text("Delete", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun StatCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun AbilityScoreCard(name: String, score: Int, modifier: Modifier = Modifier) {
    val abilityModifier = (score - 10) / 2
    val modifierText = if (abilityModifier >= 0) "+$abilityModifier" else abilityModifier.toString()

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = score.toString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = modifierText,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}