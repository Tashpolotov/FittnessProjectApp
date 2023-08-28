package com.example.fittnessprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.FitnessHomeModel
import com.example.fittnessprojectapp.databinding.ItemHomeBinding

class HomeAdapter(val onClick:(FitnessHomeModel)->Unit):ListAdapter<FitnessHomeModel, HomeAdapter.HomeViewHolder>(HomeDiff()) {


    inner class HomeViewHolder(val binding:ItemHomeBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: FitnessHomeModel) {
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.img1)
            binding.tvHiit.text = model.nameExercise
            binding.tvEnergy.text = model.energy
            binding.tvTime.text = "${model.min} min"
            binding.tvKcalRecycler.text = "${model.kcal} kcal"
            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeDiff:DiffUtil.ItemCallback<FitnessHomeModel>() {
    override fun areItemsTheSame(oldItem: FitnessHomeModel, newItem: FitnessHomeModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FitnessHomeModel, newItem: FitnessHomeModel): Boolean {
        return oldItem == newItem
    }

}
