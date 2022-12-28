package com.example.build_your_app.core.fragments.height_guess

import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WeightGuesserViewModel : ViewModel(){

    fun progressAnimation(prog : ProgressBar, showDialog: () -> Unit) {
        viewModelScope.launch {
            prog.visibility = View.VISIBLE
            delay(5000)
            prog.visibility = View.GONE
            showDialog()
        }
    }
}