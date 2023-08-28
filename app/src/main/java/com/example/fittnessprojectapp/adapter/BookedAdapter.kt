package com.example.fittnessprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.FitnessCalendarModel
import com.example.fittnessprojectapp.databinding.ItemBookedBinding

class BookedAdapter:ListAdapter<FitnessCalendarModel, BookedAdapter.BookedViewHolder>(BookedDiff()) {

    inner class BookedViewHolder(val binding:ItemBookedBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: FitnessCalendarModel) {
            binding.tvWeekDay.text = model.weekDay
            binding.tvTime.text = "${model.min} min"
            binding.tvEnergy.text = model.energy
            binding.tvTextBodyPump.text = model.nameExercise
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.img)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookedViewHolder {
        return BookedViewHolder(ItemBookedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BookedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BookedDiff:DiffUtil.ItemCallback<FitnessCalendarModel>() {
    override fun areItemsTheSame(
        oldItem: FitnessCalendarModel,
        newItem: FitnessCalendarModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: FitnessCalendarModel,
        newItem: FitnessCalendarModel
    ): Boolean {
        return oldItem == newItem
    }

}
