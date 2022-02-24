package com.interview.pagingjm.network.reddit.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.interview.pagingjm.network.api.Api
import com.interview.pagingjm.network.datasource.RedditDataSource
import com.interview.pagingjm.network.domain.ApiChildren
import retrofit2.HttpException
import java.io.IOException

class PostPagingDataSource(private val cloud: RedditDataSource) : PagingSource<String, ApiChildren>() {

    override fun getRefreshKey(state: PagingState<String, ApiChildren>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestItemToPosition(anchorPosition)?.data?.name
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ApiChildren> {
        val page = params.key
        return try {
            val response = cloud.getHotPostsPaging(page, params.loadSize)
            val nextKey = response.data.after
            LoadResult.Page(
                data = response.data.children,
                prevKey = page,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}