package com.example.sharedviewmodelforfragmentcommunication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {


    private var text = MutableLiveData<String>()

    fun setText(input: String)
    {
        text.setValue(input)
    }
    fun getText():LiveData<String>{
        return text
    }
}