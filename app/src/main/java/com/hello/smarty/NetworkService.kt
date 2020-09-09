package com.hello.smarty

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val HELLO_URL = "https://quest-io.herokuapp.com"

object NetworkService {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(HELLO_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    private val helloApi by lazy { retrofit.create(HelloApi::class.java) }

    suspend fun getHelloMessage(name: String?) = helloApi.getHelloMessage(name ?: "").await()

}