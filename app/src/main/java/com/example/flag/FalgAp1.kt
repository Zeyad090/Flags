package com.example.flag

import retrofit2.http.GET
import com.example.flag.FlagList
interface FlagApiServece {

    @GET("images")
    suspend fun getPhotos() : FlagList
}