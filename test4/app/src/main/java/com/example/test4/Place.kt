package com.example.test4

import java.io.Serializable

data class Place(
    val name: String,
    val description: String,
    val imageResId: Int,
    val latitude: Double,
    val longitude: Double
) : Serializable