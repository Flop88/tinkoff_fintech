package ru.mvlikhachev.tinkoff_fintech.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mvlikhachev.tinkoff_fintech.utils.Constants.Companion.BASE_URL

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: ModelApi by lazy {
        retrofit.create(ModelApi::class.java)
    }
}