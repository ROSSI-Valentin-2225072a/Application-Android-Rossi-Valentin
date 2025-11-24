package com.example.applicationandroidrossivalentin.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationandroidrossivalentin.entities.CharacterSheetEntity
import com.example.applicationandroidrossivalentin.repositories.CharacterSheetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class CharacterSheetViewModel(application: Application): AndroidViewModel(application) {

    private val context: Context
        get() = getApplication<Application>().applicationContext


    val characterSheetRepository = CharacterSheetRepository(context)

    val characterSheet = MutableStateFlow(CharacterSheetEntity())
    val characterSheetList = MutableStateFlow<List<CharacterSheetEntity>>(emptyList())

    init {
        getAllCharacterSheet()
    }

    fun getAllCharacterSheet() {
        viewModelScope.launch {
            characterSheetList.value = characterSheetRepository.getAllCharacterSheets()
        }
    }

    fun getCharacterSheetById(id: Int) {
        viewModelScope.launch {
            characterSheet.value = characterSheetRepository.getCharacterSheetById(id)
        }
    }

    fun insertCharacterSheet(characterSheet: CharacterSheetEntity) {
        viewModelScope.launch {
            characterSheetRepository.insertCharacterSheet(characterSheet)
        }
    }

    fun deleterCharacterSheet(characterSheet: CharacterSheetEntity) {
        viewModelScope.launch {
            characterSheetRepository.deleteCharacterSheet(characterSheet)
        }
    }

}