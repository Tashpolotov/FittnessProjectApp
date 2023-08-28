package com.example.fittnessprojectapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.date
import com.example.domain.repository.FitnessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class FitnessViewModel @Inject constructor(val repository: FitnessRepository):ViewModel() {

    private val _fitness = MutableStateFlow(State())
    val fitness : StateFlow<State> = _fitness

    fun getAvailableCalendarDates(): List<String> {
        return repository.getAvailableCalendarDates()
    }

    fun loadHome(id:String) {
        val home = repository.getHome(id)
        _fitness.value = _fitness.value.copy(home = home)
    }

    fun loadCalendar(id:String) {
        val calendar = repository.getCalendar(id)
        _fitness.value = _fitness.value.copy(calendar = calendar)
    }
}