package com.example.fittnessprojectapp.fragment

import android.graphics.Color.red
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.example.domain.model.FitnessCalendarModel
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.activity.MainActivity
import com.example.fittnessprojectapp.adapter.CalendarAdapter
import com.example.fittnessprojectapp.databinding.FragmentCalendarBinding
import com.example.fittnessprojectapp.viewmodel.FitnessViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private val adapter = CalendarAdapter(this::onClick)
    private val viewModel by viewModels<FitnessViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding.rvCalendar.adapter = adapter
        binding.rvCalendar.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    (requireActivity() as MainActivity).hideBottomNavigation()
                } else if (dy < 0) {
                    (requireActivity() as MainActivity).showBottomNavigation()
                }
            }
        })

        val availableDates = viewModel.repository.getAvailableCalendarDates()
        val calendarDays = mutableListOf<EventDay>()

        for (date in availableDates) {
            val calendarInstance = Calendar.getInstance()
            val parsedDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).parse(date)
            calendarInstance.time = parsedDate ?: Date()
            calendarDays.add(EventDay(calendarInstance, R.drawable.ic_dot)) // Используйте свою иконку
        }

        binding.calendar.setEvents(calendarDays)

        binding.calendar.setOnDayClickListener(OnDayClickListener { eventDay ->
            val selectedDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(eventDay.calendar.time)

            if (availableDates.contains(selectedDate)) {
                val calendarData = viewModel.repository.getCalendar(selectedDate)
                adapter.submitList(calendarData)
                binding.tvClassesOn.text = getDayOfWeek(selectedDate)
            } else {
                adapter.submitList(emptyList())
                binding.tvClassesOn.text = "${getDayOfWeek(selectedDate)} no training today"
            }
        })
    }

    private fun getDayOfWeek(date: String): String {
        val format = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.time = format.parse(date) ?: Date()

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        val daysOfWeek = arrayOf(
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        )
        return daysOfWeek[dayOfWeek - 1]
    }

    private fun onClick(id: FitnessCalendarModel) {
        val fragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("detail", id.details)
        bundle.putString("detail2", id.details2)
        bundle.putString("name", id.nameExercise)
        bundle.putString("energy", id.energy)
        bundle.putInt("min", id.min)
        bundle.putInt("img", id.img)

        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
