package com.interview.pagingjm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("kind") val kind: String,
    @SerializedName("data") val data: ApiData
)
