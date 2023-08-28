package com.example.fittnessprojectapp.viewmodel

import com.example.domain.model.FitnessCalendarModel
import com.example.domain.model.FitnessHomeModel
import com.example.domain.model.date

data class State (
    val home : List<FitnessHomeModel> = emptyList(),
    val calendar: List<FitnessCalendarModel> = emptyList(),
    val getAvailableCalendarDates: List<date> = emptyList()


        )