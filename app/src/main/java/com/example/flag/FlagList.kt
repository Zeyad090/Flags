package com.example.flag

data class FlagList (val error: Boolean, val msg: String, val data: List<Flag>)
data class Flag (val name: String, val flag: String)