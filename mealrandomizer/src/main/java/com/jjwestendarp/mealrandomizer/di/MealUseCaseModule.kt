package com.jjwestendarp.mealrandomizer.di

import com.jjwestendarp.mealrandomizer.domain.usecase.AddMealListUseCase
import com.jjwestendarp.mealrandomizer.domain.usecase.AddMealUseCase
import com.jjwestendarp.mealrandomizer.domain.usecase.GetMealListUseCase
import com.jjwestendarp.mealrandomizer.domain.usecase.UpdateMealListUseCase
import org.koin.dsl.module

val mealUseCaseModule = module {
    single { GetMealListUseCase(get()) }
    single { AddMealUseCase(get()) }
    single { AddMealListUseCase(get()) }
    single { UpdateMealListUseCase(get()) }
}