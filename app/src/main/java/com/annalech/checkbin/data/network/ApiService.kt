package com.annalech.checkbin.data.network


import com.annalech.checkbin.data.network.model.BinInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface ApiService {

    @GET("{bin}")
    suspend fun getBinInfo(
        @Path("bin") bin:String ,
        @Header("Accept-Version") version: String = "3"
    ): Response<BinInfo>

}