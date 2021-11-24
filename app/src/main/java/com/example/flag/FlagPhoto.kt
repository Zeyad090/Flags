package com.example.flag
import com.squareup.moshi.Json
import java.util.*

data class Flagphoto<T>(
    val error : Boolean, val msg :String, val data : List<FlagPhoto1>

)
data class FlagPhoto1(
    val name: String, val flag : String
)
