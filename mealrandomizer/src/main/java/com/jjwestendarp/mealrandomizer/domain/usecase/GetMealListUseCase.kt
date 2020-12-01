package com.jjwestendarp.mealrandomizer.domain.usecase

import com.jjwestendarp.core.base.BaseUseCase
import com.jjwestendarp.core.util.Either
import com.jjwestendarp.core.util.Failure
import com.jjwestendarp.mealrandomizer.domain.Meal
import com.jjwestendarp.mealrandomizer.domain.repository.MealsRepository

class GetMealListUseCase(private val mealsRepository: MealsRepository) : BaseUseCase.Async<List<Meal>, Unit> {
    override suspend fun run(params: Unit): Either<Failure, List<Meal>> {
        return Either.Success(mealsRepository.getMeals())
    }
}