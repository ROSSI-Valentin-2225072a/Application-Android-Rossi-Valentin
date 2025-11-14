package com.example.applicationandroidrossivalentin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationandroidrossivalentin.models.Spell
import com.example.applicationandroidrossivalentin.repositories.SpellRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SpellViewModel: ViewModel() {
    val spellRepository = SpellRepository()
    val spell = MutableStateFlow(Spell())

    suspend fun getSpell(index: String) {
        viewModelScope.launch {
            spell.value = spellRepository.getSpell(index)
        }
    }
}