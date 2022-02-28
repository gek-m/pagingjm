package com.interview.pagingjm.network.api

import com.interview.pagingjm.network.domain.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/r/redditdev/hot.json")
    suspend fun getHotPosts(): ApiResult

    @GET("/r/redditdev/hot.json")
    suspend fun getHotPostsPaging(
        @Query("after") after: String?,
        @Query("limit") size: Int
    ): ApiResult
}