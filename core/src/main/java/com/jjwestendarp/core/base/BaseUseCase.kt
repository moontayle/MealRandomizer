package com.jjwestendarp.core.base

import com.jjwestendarp.core.util.Either
import com.jjwestendarp.core.util.Failure
import com.jjwestendarp.core.util.UncaughtFailure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

interface BaseUseCase {
    interface Async<out Success, in Params> where Success : Any {
        suspend fun run(params: Params): Either<Failure, Success>

        suspend operator fun invoke(params: Params): Either<Failure, Success> {
            return withContext(Dispatchers.IO) {
                try {
                    run(params)
                } catch (e: Exception) {
                    Either.Failure(UncaughtFailure)
                }
            }
        }
    }
}