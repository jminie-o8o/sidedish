package com.example.sidedish.model

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("errorMessage")
    val errorMessage: String?
)
