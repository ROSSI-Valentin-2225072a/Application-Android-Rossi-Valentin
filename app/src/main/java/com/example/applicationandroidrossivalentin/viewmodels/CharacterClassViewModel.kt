package com.example.applicationandroidrossivalentin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationandroidrossivalentin.models.CharacterClass
import com.example.applicationandroidrossivalentin.repositories.CharacterClassRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharacterClassViewModel: ViewModel() {

    private val characterClassRepository = CharacterClassRepository()

    val characterClass = MutableStateFlow(CharacterClass())
    val characterClassList = MutableStateFlow<List<CharacterClass>>(emptyList())

    init {
        getAllCharacterClasses()
    }

    fun getAllCharacterClasses() {
        viewModelScope.launch {
            characterClassList.value = characterClassRepository.getAllCharacterClasses().results
        }
    }

    fun getCharacterClassByIndex(index: String) {
        viewModelScope.launch {
            characterClass.value = characterClassRepository.getCharacterClassByIndex(index)
        }
    }
}
