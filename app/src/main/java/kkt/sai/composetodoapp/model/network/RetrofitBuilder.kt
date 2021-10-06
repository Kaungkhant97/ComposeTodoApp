package kkt.sai.composetodoapp.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    const val BASE_URL = "https://my-json-server.typicode.com"

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val taskService: TaskService = getRetrofit().create(TaskService::class.java)
}