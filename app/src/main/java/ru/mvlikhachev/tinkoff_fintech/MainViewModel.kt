package ru.mvlikhachev.tinkoff_fintech

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mvlikhachev.tinkoff_fintech.model.Model
import ru.mvlikhachev.tinkoff_fintech.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel(){

    val myResponse: MutableLiveData<Model> = MutableLiveData()

    fun getModel() {
        viewModelScope.launch {
            val response: Model = repository.getModel()
            myResponse.value = response
        }
    }
}