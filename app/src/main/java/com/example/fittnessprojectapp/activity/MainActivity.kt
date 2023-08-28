package com.example.fittnessprojectapp.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.databinding.ActivityMainBinding
import com.example.fittnessprojectapp.fragment.BookedFragment
import com.example.fittnessprojectapp.fragment.CalendarFragment
import com.example.fittnessprojectapp.fragment.HomeFragment
import com.example.fittnessprojectapp.onboard.VpFragment
import com.example.fittnessprojectapp.onboard.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var isNavShown = true
    private var navAnimation: ObjectAnimator? = null
    private lateinit var onBoardingCompletedKey: String

    @Inject
    lateinit var preferences: Preferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingCompletedKey = "onBoardingCompleted"
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            if (!preferences.isBoardingShow()) {
                supportFragmentManager.beginTransaction().add(R.id.fr_container, VpFragment())
                    .commit()
                binding.bottomNav.visibility = View.GONE
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fr_container, HomeFragment()).commit()
                binding.bottomNav.visibility = View.VISIBLE
            }
        }

        setupBottomNavigation()
    }

     fun hideBottomNavigation() {
        if (isNavShown) {
            navAnimation?.cancel()
            navAnimation = ObjectAnimator.ofFloat(binding.bottomNav, "translationY", 0f, binding.bottomNav.height.toFloat())
            navAnimation?.duration = 800
            navAnimation?.start()
            isNavShown = false
        }
    }

     fun showBottomNavigation() {
        if (!isNavShown) {
            navAnimation?.cancel()
            navAnimation = ObjectAnimator.ofFloat(binding.bottomNav, "translationY", binding.bottomNav.height.toFloat(), 0f)
            navAnimation?.duration = 400
            navAnimation?.start()
            isNavShown = true
        }
    }

    private fun setupBottomNavigation() {
        val bottomMenu = binding.bottomNav

        val iconColorSelector = ContextCompat.getColorStateList(this, R.color.bottom_icon_colors)
        bottomMenu.itemIconTintList = iconColorSelector

        bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, HomeFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.booked -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, BookedFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.calendar -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, CalendarFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(onBoardingCompletedKey, preferences.isBoardingShow())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        preferences.setBoardingShow(savedInstanceState.getBoolean(onBoardingCompletedKey, false))
    }
    override fun onBackPressed() {
        finish()
    }
}