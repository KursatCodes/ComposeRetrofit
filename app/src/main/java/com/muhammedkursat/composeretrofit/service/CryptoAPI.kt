package com.muhammedkursat.composeretrofit.service

import com.muhammedkursat.composeretrofit.model.CrytoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {
//https://github.com/
// KursatCodes/API-Files
    @GET("KursatCodes/API-Files")
    fun getDatalar(): Call<List<CrytoModel>>
}