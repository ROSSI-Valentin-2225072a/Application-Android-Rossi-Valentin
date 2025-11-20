package com.example.applicationandroidrossivalentin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationandroidrossivalentin.models.Race
import com.example.applicationandroidrossivalentin.repositories.RaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RaceViewModel: ViewModel() {

    private val raceRepository = RaceRepository()

    val race = MutableStateFlow(Race())
    val raceList = MutableStateFlow<List<Race>>(emptyList())

    init {
        getAllRaces()
    }

    fun getAllRaces() {
        viewModelScope.launch {
            raceList.value = raceRepository.getAllRaces().results
        }
    }

    fun getRaceByIndex(index: String) {
        viewModelScope.launch {
            race.value = raceRepository.getRaceByIndex(index)
        }
    }
}