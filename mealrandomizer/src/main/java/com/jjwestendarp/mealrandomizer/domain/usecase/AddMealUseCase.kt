package com.jjwestendarp.mealrandomizer.domain.usecase

import com.jjwestendarp.core.base.BaseUseCase
import com.jjwestendarp.core.util.Either
import com.jjwestendarp.core.util.Failure
import com.jjwestendarp.mealrandomizer.domain.Meal
import com.jjwestendarp.mealrandomizer.domain.repository.MealsRepository

class AddMealUseCase(private val mealsRepository: MealsRepository) : BaseUseCase.Async<Unit, Meal> {
    override suspend fun run(params: Meal): Either<Failure, Unit> {
        return Either.Success(mealsRepository.insertMeal(params))
    }
}