package com.jjwestendarp.mealrandomizer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jjwestendarp.mealrandomizer.domain.Meals

@Dao
interface MealsDao {
    @Query("SELECT * FROM meals")
    fun getAll(): List<Meals>

    @Insert
    fun insertMeal(meal: Meals)

    @Insert
    fun insertMeals(vararg meals: Meals)
}