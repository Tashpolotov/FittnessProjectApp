package com.example.fittnessprojectapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.FitnessHomeModel
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.activity.MainActivity
import com.example.fittnessprojectapp.adapter.HomeAdapter
import com.example.fittnessprojectapp.databinding.FragmentHomeBinding
import com.example.fittnessprojectapp.viewmodel.FitnessViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = HomeAdapter(this::onClick)

    private val viewModel by viewModels<FitnessViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(id = String())
    }

    private fun initView(id: String) {

        binding.rv.adapter = adapter
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    // Прокрутка вниз - скрываем нижнюю навигационную панель с анимацией
                    (requireActivity() as MainActivity).hideBottomNavigation()
                } else if (dy < 0) {
                    // Прокрутка вверх - показываем нижнюю навигационную панель с анимацией
                    (requireActivity() as MainActivity).showBottomNavigation()
                }
            }

        })
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.fitness.collect {
                adapter.submitList(it.home)
            }
        }
        viewModel.loadHome(id)
    }

    private fun onClick(id:FitnessHomeModel) {
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
