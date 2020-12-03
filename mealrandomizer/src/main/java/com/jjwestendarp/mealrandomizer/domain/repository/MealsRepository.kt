package com.jjwestendarp.mealrandomizer.domain.repository

import com.jjwestendarp.mealrandomizer.domain.Meal

interface MealsRepository {
    suspend fun getMeals(): List<Meal>
    suspend fun insertMeal(meal: Meal)
    suspend fun insertMeals(meals: List<Meal>)
    suspend fun updateMeals(meals: List<Meal>)
}