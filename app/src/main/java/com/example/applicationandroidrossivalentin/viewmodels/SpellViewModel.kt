package com.example.applicationandroidrossivalentin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationandroidrossivalentin.models.Spell
import com.example.applicationandroidrossivalentin.repositories.SpellRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SpellViewModel: ViewModel() {
    private val spellRepository = SpellRepository()
    val spell = MutableStateFlow(Spell())
    val spellList = MutableStateFlow(listOf<Spell>())

    init {
        getAllSpells()
    }

    fun getSpell(index: String) {
        viewModelScope.launch {
            spell.value = spellRepository.getSpell(index)
        }
    }

    fun getFilteredSpells(levels: List<Int>, schools: List<String>) {
        viewModelScope.launch {
            spellList.value = spellRepository.getFilteredSpells(levels, schools).results
        }
    }

    fun getAllSpells() {
        viewModelScope.launch {
            spellList.value = spellRepository.getAllSpell().results
        }
    }
}