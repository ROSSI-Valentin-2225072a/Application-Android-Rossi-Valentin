package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationandroidrossivalentin.viewmodels.CharacterClassViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterClasses(onClickHome: () -> Unit) {

    val viewmodel = viewModel<CharacterClassViewModel>()
    val characterClassesList = viewmodel.characterClassList.collectAsStateWithLifecycle()

    Scaffold ( topBar = {
        TopAppBar(
            title = { Text("Character Classes") },
            navigationIcon = {
                IconButton(onClick = onClickHome) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back to menu",
                    )
                }
            },
        )
    }, modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(top = 16.dp, bottom = 16.dp)
    ) { innerPadding ->
        Column {
            HorizontalMultiBrowseCarousel(
                preferredItemWidth = 186.dp,
                modifier = Modifier.padding(innerPadding),
                state = rememberCarouselState { characterClassesList.value.size }
            ) { pos ->
                val characterClass = characterClassesList.value[pos]

                val context = LocalContext.current
                val resourceId = remember(characterClass.index) {
                    context.resources.getIdentifier(
                        characterClass.index,
                        "drawable",
                        context.packageName
                    )
                }

                Image(
                    modifier = Modifier
                        .height(205.dp)
                        .maskClip(MaterialTheme.shapes.extraLarge),
                    painter = painterResource(id = resourceId),
                    contentDescription = characterClass.name,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}