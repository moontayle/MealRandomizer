package com.jjwestendarp.mealrandomizer.di

import androidx.room.Room
import com.jjwestendarp.mealrandomizer.data.MealDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val mealDatabaseModule = module {
    single { Room.databaseBuilder(androidApplication(), MealDatabase::class.java, "meal-db")
            .build()
    }

    single { get<MealDatabase>().mealsDao() }
}