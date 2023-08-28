package com.example.footballproject.onboard

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.onboard.BoardFragment
import com.example.fittnessprojectapp.onboard.model.OnBoardModel
import dagger.hilt.android.qualifiers.ApplicationContext

class BoardAdapter (@ApplicationContext fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    private val listBoarding = arrayOf(
        OnBoardModel(
            "Welcome to Fitness Hub",
            R.drawable.img_fitness_home_fragment,
            "Embark on your fitness journey with Fitness Hub. Stay motivated and achieve your health goals through tailored workouts and expert guidance."
        ),
        OnBoardModel(
            "Track Workouts and Progress",
            R.drawable.img_fitness_home_fragment,
            "Monitor your workout routines and track your fitness progress with Fitness Hub. Stay motivated as you see your improvements over time."
        )
    )
    override fun getItemCount(): Int = listBoarding.size

    override fun createFragment(position: Int): Fragment {
        val data = bundleOf("board" to listBoarding[position])
        val fragment = BoardFragment()
        fragment.arguments = data
        return fragment
    }
}