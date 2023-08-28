package com.example.domain.usecase

import com.example.domain.repository.FitnessRepository

class FitnessUseCase(private val repository: FitnessRepository) {

    operator fun invoke(id:String){
        repository.getHome(id)
        repository.getCalendar(id)
        repository.getAvailableCalendarDates()
    }

}