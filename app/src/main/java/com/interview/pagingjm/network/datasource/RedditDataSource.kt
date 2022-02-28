package com.interview.pagingjm.network.datasource

import com.interview.pagingjm.network.domain.ApiResult

interface RedditDataSource {

    suspend fun getRedditHotTreads(): ApiResult

    suspend fun getHotPostsPaging(after: String?, size: Int): ApiResult
}