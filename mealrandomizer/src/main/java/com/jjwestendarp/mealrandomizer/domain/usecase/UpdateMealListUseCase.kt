package com.jjwestendarp.mealrandomizer.domain.usecase

import com.jjwestendarp.core.base.BaseUseCase
import com.jjwestendarp.core.util.Either
import com.jjwestendarp.core.util.Failure
import com.jjwestendarp.mealrandomizer.domain.Meal
import com.jjwestendarp.mealrandomizer.domain.repository.MealsRepository

class UpdateMealListUseCase(private val mealsRepository: MealsRepository) : BaseUseCase.Async<Unit, List<Meal>> {
    override suspend fun run(params: List<Meal>): Either<Failure, Unit> {
        return Either.Success(mealsRepository.updateMeals(params))
    }
}