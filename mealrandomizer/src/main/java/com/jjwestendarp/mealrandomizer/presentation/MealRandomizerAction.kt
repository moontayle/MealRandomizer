package com.jjwestendarp.mealrandomizer.presentation

import com.jjwestendarp.mealrandomizer.domain.Meal

sealed class MealRandomizerAction {
    object DefaultAction : MealRandomizerAction()

    object LoadedAction : MealRandomizerAction()

    data class RandomizeMealAction(val mealList: List<Meal>) : MealRandomizerAction()
}
