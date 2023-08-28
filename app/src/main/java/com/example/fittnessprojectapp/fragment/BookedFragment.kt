package com.example.fittnessprojectapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.activity.MainActivity
import com.example.fittnessprojectapp.adapter.BookedAdapter
import com.example.fittnessprojectapp.databinding.FragmentBookedBinding
import com.example.fittnessprojectapp.viewmodel.FitnessViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class BookedFragment : Fragment() {

    private lateinit var binding:FragmentBookedBinding
    private val adapter = BookedAdapter()
    private val viewModel by viewModels<FitnessViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(id = String())
    }

    private fun initView(id:String) {
        binding.rvCalendar.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy>0) {
                    (requireActivity() as MainActivity).hideBottomNavigation()
                } else if(dy<0){
                    (requireActivity() as MainActivity).showBottomNavigation()
                }
            }
        })

        binding.rvCalendar.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.fitness.collect{
                adapter.submitList(it.calendar)
            }
        }
        viewModel.loadCalendar(id)
    }
}