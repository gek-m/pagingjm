package com.interview.pagingjm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiChildren(
    @SerializedName("kind") val kind: String,
    @SerializedName("data") val data: ApiChildrenData
)
