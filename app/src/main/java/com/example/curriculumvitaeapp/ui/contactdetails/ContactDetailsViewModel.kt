package com.example.curriculumvitaeapp.ui.contactdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactDetailsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is contactdetails Fragment"
    }
    val text: LiveData<String> = _text
}