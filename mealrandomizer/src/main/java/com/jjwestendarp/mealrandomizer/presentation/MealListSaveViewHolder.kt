package com.jjwestendarp.mealrandomizer.presentation

import androidx.recyclerview.widget.RecyclerView
import com.jjwestendarp.mealrandomizer.databinding.ListSaveButtonBinding

class MealListSaveViewHolder (private val binding: ListSaveButtonBinding, private val listener: ListItemClickListener) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        binding.btnSaveList.setOnClickListener { listener.onClick() }
    }
}