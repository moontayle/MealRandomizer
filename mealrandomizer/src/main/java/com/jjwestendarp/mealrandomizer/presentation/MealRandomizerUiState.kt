package com.jjwestendarp.mealrandomizer.presentation

import com.jjwestendarp.core.base.BaseUiState
import com.jjwestendarp.mealrandomizer.domain.Meal

data class MealRandomizerUiState(
    override val hasError: Boolean = false,
    override val isLoading: Boolean = false,
    val mealList: List<Meal> = emptyList(),
    val action: MealRandomizerAction = MealRandomizerAction.DefaultAction
) : BaseUiState