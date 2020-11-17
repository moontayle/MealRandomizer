package com.jjwestendarp.mealrandomizer.presentation

import com.jjwestendarp.core.base.BaseViewModel
import com.jjwestendarp.core.util.Failure

class MealRandomizerViewModel : BaseViewModel<MealRandomizerUiState>(MealRandomizerUiState()) {
    override fun <F : Failure> onError(failure: F) {
        TODO("Not yet implemented")
    }
}