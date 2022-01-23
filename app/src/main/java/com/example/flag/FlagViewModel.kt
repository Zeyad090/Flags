package com.example.flag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FlagViewModel : ViewModel() {

    private var _flag = MutableLiveData<String>()
    val flag: LiveData<String> = _flag
    private var _flagPhotos = MutableLiveData<List<Flag>>()
    val flagPhotos: LiveData<List<Flag>> = _flagPhotos

    init {
        getFlagPhoto()
    }


    fun getFlagPhoto() {
        viewModelScope.launch {
            try {
                _flagPhotos.value = FlagApiO.retrofitService.getPhotos().data
                _flag.value = "Success"

            } catch (e: Exception) {
                _flag.value = "Failure: ${e.message}"
            }
        }

    }
}