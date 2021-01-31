package ru.mvlikhachev.tinkoff_fintech.api

import retrofit2.http.GET
import ru.mvlikhachev.tinkoff_fintech.model.Model

interface ModelApi {

    @GET("random?json=true")
    suspend fun getModel() : Model
}