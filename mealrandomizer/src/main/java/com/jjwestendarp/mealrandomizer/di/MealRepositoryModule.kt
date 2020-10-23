package com.jjwestendarp.mealrandomizer.di

import com.jjwestendarp.mealrandomizer.data.repository.MealsRepositoryImpl
import com.jjwestendarp.mealrandomizer.domain.repository.MealsRepository
import org.koin.dsl.module

val mealRepositoryModule = module {
    single<MealsRepository> { MealsRepositoryImpl(get()) }
}