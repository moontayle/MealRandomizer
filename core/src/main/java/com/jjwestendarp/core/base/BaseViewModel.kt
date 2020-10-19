package com.jjwestendarp.core.base

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjwestendarp.core.util.Either
import com.jjwestendarp.core.util.Failure
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

abstract class BaseViewModel<UiStateType: BaseUiState>(uiState: UiStateType): ViewModel() {

    val uiState: UiStateType
    get() = uiStateLiveData.value ?: throw IllegalStateException("BaseUiState is null")

    private val _uiStateLiveData: MutableLiveData<UiStateType> = MutableLiveData()
    val uiStateLiveData: LiveData<UiStateType> = _uiStateLiveData

    init {
        _uiStateLiveData.value = uiState
    }

    open fun onArgumentsReceived(arguments: Bundle) {}

    fun updateUiState(update: (UiStateType) -> UiStateType) {
        uiStateLiveData.value?.let {
            val newState = update(it)

            check(!(newState === uiStateLiveData.value)) { "BaseUiState is the same object. Use .copy" }

            _uiStateLiveData.value = newState
        } ?: throw IllegalStateException("BaseUiState is null")
    }

    fun <T : Any, Params : Any> asyncUseCase(
        useCase: BaseUseCase.Async<T, Params>,
        params: Params,
        onSuccess: (T) -> Unit
    ) {
        viewModelScope.launch {
            useCase(params).handle(
                onFailure = {
                    onError(it)
                },
                onSuccess = {
                    onSuccess(it)
                }
            )
        }
    }

    abstract fun <F : Failure> onError(failure: F)

}