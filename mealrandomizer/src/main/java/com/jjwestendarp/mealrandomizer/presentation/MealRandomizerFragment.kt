package com.jjwestendarp.mealrandomizer.presentation

import com.jjwestendarp.core.base.BaseFragment
import com.jjwestendarp.mealrandomizer.R
import com.jjwestendarp.mealrandomizer.databinding.FragmentMealRandomizerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealRandomizerFragment : BaseFragment<MealRandomizerUiState, MealRandomizerViewModel, FragmentMealRandomizerBinding>(
    R.layout.fragment_meal_randomizer)  {
    override val viewModel: MealRandomizerViewModel by viewModel()
}