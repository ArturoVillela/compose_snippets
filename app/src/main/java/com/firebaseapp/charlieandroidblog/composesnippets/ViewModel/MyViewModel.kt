package com.firebaseapp.charlieandroidblog.composesnippets.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firebaseapp.charlieandroidblog.composesnippets.model.Ejemplos

class MyViewModel:ViewModel() {

    val list = MutableLiveData<ArrayList<String>>()

    fun start(){
            list.value = Ejemplos.getEjemplos()
    }
}