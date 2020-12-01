package com.jjwestendarp.mealrandomizer

import android.app.Application
import com.jjwestendarp.mealrandomizer.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealRandomizerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MealRandomizerApp)
            modules(listOf(mealRandomizerModule, mealDatabaseModule, mealRepositoryModule, mealSourceModule, mealUseCaseModule))
        }
    }
}