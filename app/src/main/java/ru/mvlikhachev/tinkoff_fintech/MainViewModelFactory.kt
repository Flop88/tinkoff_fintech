package ru.mvlikhachev.tinkoff_fintech

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.mvlikhachev.tinkoff_fintech.repository.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}