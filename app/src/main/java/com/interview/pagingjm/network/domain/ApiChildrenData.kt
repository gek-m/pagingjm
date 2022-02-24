package com.interview.pagingjm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiChildrenData(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("num_comments") val numComments: Int,
    @SerializedName("score") val score: Int,
    @SerializedName("name") val name: String
)
