package com.jjwestendarp.mealrandomizer.presentation

import androidx.recyclerview.widget.RecyclerView
import com.jjwestendarp.mealrandomizer.databinding.ListMealBinding
import com.jjwestendarp.mealrandomizer.domain.Meal
import java.text.SimpleDateFormat
import java.util.*

class MealRandomizerViewHolder(private val binding: ListMealBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(meal: Meal) {
        binding.tvListMealName.text = meal.mealName
        binding.tvListMealDate.text = convertDate(meal.lastUsed)
    }

    private fun convertDate(lastUsed: Long): String {
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.US)
        cal.timeInMillis = lastUsed
        return dateFormat.format(cal.time)
    }
}