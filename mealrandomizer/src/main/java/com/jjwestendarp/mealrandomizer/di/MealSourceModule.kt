package com.jjwestendarp.mealrandomizer.di

import com.jjwestendarp.mealrandomizer.data.source.MealSource
import org.koin.dsl.module

val mealSourceModule = module {
    single { MealSource(get()) }
}