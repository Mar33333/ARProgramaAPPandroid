package com.curso.android.app.practica.pruebatp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    public val compareResult = MutableLiveData<String>()
    val compareResultx: LiveData<String> = compareResult

    fun compareText(text1: String, text2: String) {
        if (text1 == text2) {
            compareResult.value = "Los textos ingresados son iguales"
        }else{
            compareResult.value = "Los textos ingresados son diferentes"
        }
    }
}