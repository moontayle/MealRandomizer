package com.jjwestendarp.core.util

sealed class Failure {
    abstract class FeatureFailure : Failure()
    abstract class DataFailure: Failure()
}

object UncaughtFailure : Failure()