package com.jjwestendarp.mealrandomizer

import android.app.Application
import com.jjwestendarp.mealrandomizer.di.mealDatabaseModule
import com.jjwestendarp.mealrandomizer.di.mealRandomizerModule
import com.jjwestendarp.mealrandomizer.di.mealRepositoryModule
import com.jjwestendarp.mealrandomizer.di.mealSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealRandomizerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MealRandomizerApp)
            modules(listOf(mealRandomizerModule, mealDatabaseModule, mealRepositoryModule, mealSourceModule))
        }
    }
}