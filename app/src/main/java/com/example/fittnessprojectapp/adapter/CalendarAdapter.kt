package com.example.fittnessprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.FitnessCalendarModel
import com.example.domain.model.FitnessHomeModel
import com.example.fittnessprojectapp.databinding.ItemCalendarBinding
import java.util.Calendar

class CalendarAdapter(val onClick:(FitnessCalendarModel)->Unit):ListAdapter<FitnessCalendarModel, CalendarAdapter.CalendarViewHolder>(CalendarDiff()) {



    inner class CalendarViewHolder(val binding:ItemCalendarBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: FitnessCalendarModel) {
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.img)
            binding.tvTextBodyPump.text = model.nameExercise
            binding.tvTextMin.text = "${model.min} min"
            itemView.setOnClickListener {
                onClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder(ItemCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CalendarDiff:DiffUtil.ItemCallback<FitnessCalendarModel>() {
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
