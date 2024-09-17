package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Mars!\n\n Check Dashboard to find real Mars Photos! If Photos do not load check Internet your connection and try to switch between home and dashboard pages!"
    }
    val text: LiveData<String> = _text
}