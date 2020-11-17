package com.jjwestendarp.mealrandomizer.di

import com.jjwestendarp.mealrandomizer.presentation.MealRandomizerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val mealRandomizerModule: Module = module(createdAtStart = true, override = true) {
    viewModel { MealRandomizerViewModel() }
}