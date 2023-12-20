package com.muhammedkursat.composeretrofit.service

import com.muhammedkursat.composeretrofit.model.CrytoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {
    //https://raw.githubusercontent.com/
    // KursatCodes/API-Files/master/cryptoApi.json
    @GET("KursatCodes/API-Files/master/cryptoApi.json")
    fun getDatalar(): Call<List<CrytoModel>>
}