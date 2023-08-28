package com.example.fittnessprojectapp.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.activity.MainActivity
import com.example.fittnessprojectapp.databinding.FragmentBoardBinding
import com.example.fittnessprojectapp.fragment.HomeFragment
import com.example.fittnessprojectapp.onboard.model.OnBoardModel
import com.example.fittnessprojectapp.onboard.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment(R.layout.fragment_board) {

    @Inject
    lateinit var preferences: Preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("board") as OnBoardModel
        val binding = FragmentBoardBinding.bind(view)

        binding.tvName.text = data.desc
        binding.tvDesc.text = data.text

        binding.btnNext.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.fr_container, HomeFragment())
                .commit()
            preferences.setBoardingShow(true)
            (activity as? MainActivity)?.binding?.bottomNav?.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}