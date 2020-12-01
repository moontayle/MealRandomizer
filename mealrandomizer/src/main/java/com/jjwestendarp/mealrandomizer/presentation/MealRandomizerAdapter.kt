package com.jjwestendarp.mealrandomizer.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjwestendarp.mealrandomizer.databinding.ListMealBinding
import com.jjwestendarp.mealrandomizer.domain.Meal

class MealRandomizerAdapter(private val mealList: List<Meal>) : RecyclerView.Adapter<MealRandomizerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealRandomizerViewHolder {
        val binding = ListMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealRandomizerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealRandomizerViewHolder, position: Int) {
        holder.bind(mealList[position])
    }

    override fun getItemCount(): Int = mealList.size

}