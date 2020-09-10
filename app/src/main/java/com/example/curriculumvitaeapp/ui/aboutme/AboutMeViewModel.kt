package com.example.curriculumvitaeapp.ui.aboutme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutMeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is aboutme Fragment"
    }
    val text: LiveData<String> = _text
}