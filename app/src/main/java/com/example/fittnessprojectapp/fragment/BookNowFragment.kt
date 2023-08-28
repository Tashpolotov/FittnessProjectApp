package com.example.fittnessprojectapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.applandeo.materialcalendarview.CalendarView

import com.example.fittnessprojectapp.R
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class BookNowFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var bookButton: Button
    private var selectedDate: Date? = null
    private lateinit var imgBtn : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_now, container, false)
        calendarView = view.findViewById(R.id.calendar)
        nameEditText = view.findViewById(R.id.nameEditText)
        emailEditText = view.findViewById(R.id.emailEditText)
        bookButton = view.findViewById(R.id.ntb_book)
        imgBtn = view.findViewById(R.id.img_back)

        imgBtn.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
        }

        calendarView.setOnDayClickListener { eventDay ->
            selectedDate = eventDay.calendar.time
            Toast.makeText(requireContext(), "Date selected: ${SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(selectedDate)}", Toast.LENGTH_SHORT).show()
        }

        bookButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            if (selectedDate != null && name.isNotBlank() && email.isNotBlank()) {
                val formattedDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(selectedDate!!)
                val registrationMessage = "You have successfully booked for $formattedDate"
                Toast.makeText(requireContext(), registrationMessage, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Please select a date and enter name and email", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}