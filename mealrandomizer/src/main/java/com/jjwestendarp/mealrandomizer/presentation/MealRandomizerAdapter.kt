package com.jjwestendarp.mealrandomizer.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjwestendarp.mealrandomizer.databinding.ListMealBinding
import com.jjwestendarp.mealrandomizer.databinding.ListSaveButtonBinding
import com.jjwestendarp.mealrandomizer.domain.Meal

class MealRandomizerAdapter(private val mealList: List<Meal>, private val onClickListener: ListItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_MEAL = 0
    private val TYPE_LAST = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_MEAL -> {
                val binding = ListMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MealRandomizerViewHolder(binding)
            }
            else -> { // TYPE_LAST
                val binding = ListSaveButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MealListSaveViewHolder(binding, onClickListener)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MealRandomizerViewHolder -> {
                holder.bind(mealList[position])
            }
            is MealListSaveViewHolder -> {
                holder.bind()
            }
            else -> {}
        }

    }

    override fun getItemCount(): Int = mealList.size

    override fun getItemViewType(position: Int): Int {
        if (position == mealList.lastIndex) {
            return TYPE_LAST
        }
        return TYPE_MEAL
    }

}