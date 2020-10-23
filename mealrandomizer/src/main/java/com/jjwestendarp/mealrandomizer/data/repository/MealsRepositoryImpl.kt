package com.jjwestendarp.mealrandomizer.data.repository

import com.jjwestendarp.mealrandomizer.data.source.MealSource
import com.jjwestendarp.mealrandomizer.domain.Meal
import com.jjwestendarp.mealrandomizer.domain.repository.MealsRepository

class MealsRepositoryImpl(private val mealSource: MealSource) : MealsRepository {
    override suspend fun getMeals(): List<Meal> {
        return mealSource.getMeals()
    }

    override suspend fun insertMeal(meal: Meal) {
        mealSource.insertMeal(meal)
    }

    override suspend fun insertMeals(meals: List<Meal>) {
        mealSource.insertMeals(meals)
    }
}