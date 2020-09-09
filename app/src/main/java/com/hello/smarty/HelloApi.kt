package com.hello.smarty

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HelloApi {

    @GET("/user/{name}")
    fun getHelloMessage(@Path("name") name: String): Call<String>

}