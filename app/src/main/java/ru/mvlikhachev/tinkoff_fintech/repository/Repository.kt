package ru.mvlikhachev.tinkoff_fintech.repository

import ru.mvlikhachev.tinkoff_fintech.api.RetrofitInstance
import ru.mvlikhachev.tinkoff_fintech.model.Model

class Repository {

    suspend fun getModel() : Model {
        return RetrofitInstance.api.getModel()
    }
}