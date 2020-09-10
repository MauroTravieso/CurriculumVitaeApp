package com.example.curriculumvitaeapp.ui.workexperience

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkExperienceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is workexperience Fragment"
    }
    val text: LiveData<String> = _text
}