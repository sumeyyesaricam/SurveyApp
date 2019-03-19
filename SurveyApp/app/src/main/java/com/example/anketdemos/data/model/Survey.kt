package com.example.anketdemos.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


data class Survey(
    @Expose
    @SerializedName("questionId")
    var questionId: String? = null,

    @Expose
    @SerializedName("content")
    var content: String? = null,
    @Expose
    @SerializedName("response")
    var response: String? = null,
    @Expose
    @SerializedName("otherResponse")
    var otherResponse: String? = null
)