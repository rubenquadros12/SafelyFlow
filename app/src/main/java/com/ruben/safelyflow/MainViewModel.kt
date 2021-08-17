package com.ruben.safelyflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Created by Ruben Quadros on 16/08/21
 **/
class MainViewModel: ViewModel() {

    private val counterValue: MutableStateFlow<Int> = MutableStateFlow(0)

    fun getCount() {
        viewModelScope.launch {
            for (i in 0..10) {
                delay(2000)
                Log.d("Ruben", "Counter value ${counterValue.value}")
                counterValue.value = i
            }
        }
    }

    fun getCounterValue(): StateFlow<Int> = counterValue.asStateFlow()
}
