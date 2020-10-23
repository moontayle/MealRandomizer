package com.jjwestendarp.mealrandomizer.data.source

import com.jjwestendarp.mealrandomizer.data.MealsDao
import com.jjwestendarp.mealrandomizer.domain.Meal

class MealSource(private val mealsDao: MealsDao) {

    suspend fun getMeals(): List<Meal> {
        return mealsDao.getAll()
    }

    suspend fun insertMeal(meal: Meal) {
        mealsDao.insertMeal(meal)
    }

    suspend fun insertMeals(meals: List<Meal>) {
        mealsDao.insertMeals(*meals.toTypedArray())
    }
}