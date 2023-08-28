package com.example.fittnessprojectapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fittnessprojectapp.R
import com.example.fittnessprojectapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding:FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initView()
    }

    private fun initView() {

        binding.btnBookNow.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, BookNowFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.imgBack.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
        }


            val detail = arguments?.getString("detail")
            val detail2 = arguments?.getString("detail2")
            val name = arguments?.getString("name")
            val energy = arguments?.getString("energy")
            val min = arguments?.getInt("min")
            val img = arguments?.getInt("img")

        binding.imgBig.setImageResource(img?: R.drawable.img_book_classe_fragment1)
        binding.tvLowEnergy.text = energy
        binding.tvTime.text = "${min} min"
        binding.tvNameExs.text = name
        binding.tvDetalsText1.text = detail
        binding.tvDetalsText2.text = detail2
    }

    private fun initListener() {
        binding.readMoreTextView.setOnClickListener {
            if (binding.tvDetalsText2.maxLines == Integer.MAX_VALUE) {
                binding.tvDetalsText2.maxLines > 3
                binding.readMoreTextView.visibility = View.VISIBLE
            } else {
                binding.tvDetalsText2.maxLines = Integer.MAX_VALUE
                binding.readMoreTextView.visibility = View.GONE
            }
        }
        binding.tvDetalsText2.setOnClickListener {
            binding.tvDetalsText2.maxLines = 3
            binding.readMoreTextView.visibility = View.VISIBLE
    }
    }
}