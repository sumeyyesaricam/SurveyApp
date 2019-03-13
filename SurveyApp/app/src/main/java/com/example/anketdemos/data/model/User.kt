package com.example.anketdemos.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("userId")
    var userId: String? = null,

    @Expose
    @SerializedName("name")
    var name: String? = null,
    @Expose
    @SerializedName("token")
    var token: String? = null
)