package ru.mvlikhachev.tinkoff_fintech.repository

import retrofit2.Response
import ru.mvlikhachev.tinkoff_fintech.api.RetrofitInstance
import ru.mvlikhachev.tinkoff_fintech.model.Model

class Repository {

    suspend fun getModel() : Response<Model> {
        return RetrofitInstance.api.getModel()
    }
}