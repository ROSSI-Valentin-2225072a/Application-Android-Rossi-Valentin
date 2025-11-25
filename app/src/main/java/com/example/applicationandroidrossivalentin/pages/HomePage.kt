package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.applicationandroidrossivalentin.composants.MenuCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    onClickCharacterSheets: () -> Unit,
    onClickSpells: () -> Unit,
    onClickCharacterClasses: () -> Unit,
    onClickRaces: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "D&D Companion",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Welcome, Adventurer!",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Choose your path",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                MenuCard(
                    title = "My Characters",
                    description = "Manage your character sheets",
                    icon = Icons.Filled.Person,
                    onClick = onClickCharacterSheets
                )

                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Spells",
                    description = "Browse magical spells",
                    icon = Icons.Filled.School,
                    onClick = onClickSpells
                )

                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Classes",
                    description = "Explore character classes",
                    icon = Icons.Filled.School,
                    onClick = onClickCharacterClasses
                )

                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Races",
                    description = "Discover playable races",
                    icon = Icons.Filled.Person,
                    onClick = onClickRaces
                )
            }
        }
    }
}
