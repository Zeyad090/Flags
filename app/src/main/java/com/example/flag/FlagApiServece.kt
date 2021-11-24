package com.example.flag



import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET

private const val BASE_URL =
    " https://countriesnow.space/api/v0.1/countries/flag/image"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface FlagApiServece {

    @GET("images")
    suspend fun getPhotos() : Flagphoto<FlagPhoto1>
}


object flagApi {
    val retrofitService: FlagApiServece by lazy { retrofit.create(FlagApiServece::class.java) }
}