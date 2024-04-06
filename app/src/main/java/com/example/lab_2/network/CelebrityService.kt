package com.example.lab_2.network

import com.example.lab_2.model.Celebrity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface CelebrityService {
    @GET("celebrity?x-api-key=xikwiiMdTsxfpzmkg9GABQ==vXPM2gKARQRgH92p")
    fun fetchCelebrityList(@Query("name") name:String): Call<List<Celebrity>>
//    fun fetchCelebrityList(): Call<List<Celebrity>>

}