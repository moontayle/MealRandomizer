package com.jjwestendarp.mealrandomizer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jjwestendarp.mealrandomizer.domain.Meal

@Dao
interface MealsDao {
    @Query("SELECT * FROM meal")
    fun getAll(): List<Meal>

    @Insert
    fun insertMeal(meal: Meal)

    @Insert
    fun insertMeals(vararg meals: Meal)

    @Update(entity = Meal::class)
    fun update(meal: Meal)
}