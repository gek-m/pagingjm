package com.interview.pagingjm.network.datasource

import com.interview.pagingjm.network.api.Api
import com.interview.pagingjm.network.domain.ApiResult

class CloudRedditDataSource(private val api: Api): RedditDataSource {
    override suspend fun getRedditHotTreads(): ApiResult =
        api.getHotPosts()

    override suspend fun getHotPostsPaging(after: String?, size: Int): ApiResult =
        api.getHotPostsPaging(after, size)
}