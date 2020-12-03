package com.jjwestendarp.mealrandomizer.data.source

import com.jjwestendarp.mealrandomizer.data.MealsDao
import com.jjwestendarp.mealrandomizer.domain.Meal

class MealSource(private val mealsDao: MealsDao) {

    fun getMeals(): List<Meal> {
        return mealsDao.getAll()
    }

    fun insertMeal(meal: Meal) {
        mealsDao.insertMeal(meal)
    }

    fun insertMeals(meals: List<Meal>) {
        mealsDao.insertMeals(*meals.toTypedArray())
    }

    fun updateMeal(meal: Meal) {
        mealsDao.update(meal)
    }
}