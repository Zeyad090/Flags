package com.example.flag.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flag.flagApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel(){
    private val _Myflags = MutableLiveData<String>()

    val Myflags: LiveData<String> = _Myflags

    init {
      getflagPhotos()
    }

    private fun getflagPhotos() {
        viewModelScope.launch {
            try {
                val falglist = flagApi.retrofitService.getPhotos()
                _Myflags.value = "Success: ${falglist} Flags photos retrieved Successfully"
            } catch (e: Exception) {
                _Myflags.value = "Failure: ${e.message}"
            }
        }
    }
}
