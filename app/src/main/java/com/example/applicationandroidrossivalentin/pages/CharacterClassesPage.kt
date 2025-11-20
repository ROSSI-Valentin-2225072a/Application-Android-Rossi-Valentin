package com.example.applicationandroidrossivalentin.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    val viewModel = viewModel<CharacterClassViewModel>()
    val characterClass = viewModel.characterClass.collectAsStateWithLifecycle()
    val characterClassesList = viewModel.characterClassList.collectAsStateWithLifecycle()
    val sheetState = rememberModalBottomSheetState()

    var showBottomSheet by remember { mutableStateOf(false) }


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
            Column{
                Image(
                    modifier = Modifier
                        .height(205.dp)
                        .maskClip(MaterialTheme.shapes.extraLarge)
                        .clickable(onClick = {
                            showBottomSheet = true
                            viewModel.getCharacterClassByIndex(characterClass.index)
                        }),
                    painter = painterResource(id = resourceId),
                    contentDescription = characterClass.name,
                    contentScale = ContentScale.Crop
                )
                Text(characterClass.name)
            }
        }
        if(showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                Text(characterClass.value.name)
            }
        }
    }
}