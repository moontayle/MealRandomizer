package com.jjwestendarp.mealrandomizer.presentation

import com.jjwestendarp.core.base.BaseViewModel
import com.jjwestendarp.core.util.Failure
import com.jjwestendarp.mealrandomizer.domain.Meal
import com.jjwestendarp.mealrandomizer.domain.usecase.AddMealListUseCase
import com.jjwestendarp.mealrandomizer.domain.usecase.AddMealUseCase
import com.jjwestendarp.mealrandomizer.domain.usecase.GetMealListUseCase
import com.jjwestendarp.mealrandomizer.domain.usecase.UpdateMealListUseCase
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class MealRandomizerViewModel(
        private val getMealListUseCase: GetMealListUseCase,
        private val addMealUseCase: AddMealUseCase,
        private val addMealListUseCase: AddMealListUseCase,
        private val updateMealListUseCase: UpdateMealListUseCase
) : BaseViewModel<MealRandomizerUiState>(MealRandomizerUiState()) {
    override fun <F : Failure> onError(failure: F) {
        TODO("Not yet implemented")
    }

    fun setDefaultAction() {
        updateUiState { uiState -> uiState.copy(action = MealRandomizerAction.DefaultAction) }
    }

    fun addItem(mealName: String) {
        asyncUseCase(addMealUseCase, Meal(mealName, 0), { getMealList() })
    }

    fun addItemList(list: List<Meal>) {
        asyncUseCase(addMealListUseCase, list, { getMealList() })
    }

    fun getMealList() {
        asyncUseCase(getMealListUseCase, Unit, ::onGetMealListSuccess)
    }

    fun saveListToDatabase(list: List<Meal>) {
        asyncUseCase(updateMealListUseCase, list, {})
    }

    private fun onGetMealListSuccess(mealList: List<Meal>) {
        updateUiState { uiState -> uiState.copy(mealList = mealList, action = MealRandomizerAction.LoadedAction) }
    }

    fun shuffleMeals() {
        val shuffledList = uiState.mealList.shuffled()
        val simulatedCalendar = Calendar.getInstance()
        val newList = mutableListOf<Meal>()
        shuffledList.forEach {
            val currentSimulatedTime = simulatedCalendar.timeInMillis
            val difference = currentSimulatedTime - it.lastUsed
            if (TimeUnit.MILLISECONDS.toDays(difference) >= 30) { //TODO: Need a settings value to track the number of days since last use as well as a way to simply reset that value
                newList.add(it.copy(lastUsed = currentSimulatedTime))
                simulatedCalendar.add(Calendar.DATE, 2)
            }
        }
        updateUiState { uiState -> uiState.copy(action = MealRandomizerAction.RandomizeMealAction(newList.take(15))) }
    }


}