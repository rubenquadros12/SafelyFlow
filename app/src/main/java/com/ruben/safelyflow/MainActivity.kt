package com.ruben.safelyflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getCount()
/*        lifecycleScope.launchWhenStarted {
            mainViewModel.getCounterValue().collect {
                findViewById<TextView>(R.id.counterTv).text = it.toString()
            }
        }*/
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.getCounterValue().collect {
                    findViewById<TextView>(R.id.counterTv).text = it.toString()
                }
            }
        }
    }
}