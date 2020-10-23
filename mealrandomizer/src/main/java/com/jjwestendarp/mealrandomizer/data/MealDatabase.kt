package com.jjwestendarp.mealrandomizer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjwestendarp.mealrandomizer.domain.Meal

@Database(entities = [Meal::class], version = 1)
abstract class MealDatabase : RoomDatabase() {
    abstract fun mealsDao(): MealsDao
}