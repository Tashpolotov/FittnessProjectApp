package com.example.domain.repository

import com.example.domain.model.FitnessCalendarModel
import com.example.domain.model.FitnessHomeModel
import com.example.domain.model.date

interface FitnessRepository {

    fun getHome(id:String):List<FitnessHomeModel>

    fun getCalendar(id: String): List<FitnessCalendarModel>

    fun getAvailableCalendarDates():List<String>
}