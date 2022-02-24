package com.interview.pagingjm.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.interview.pagingjm.di.Scopes
import com.interview.pagingjm.network.reddit.paging.PostPagingDataSource
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent

class MainViewModel : ViewModel() {

    private val scope = KoinJavaComponent.getKoin().createScope<PostPagingDataSource>()

    val posts = Pager(
        config = getDefaultPagingConfig(),
        pagingSourceFactory = { scope.get<PostPagingDataSource>(named(Scopes.CLOUD_DATA_SOURCE)) }
    ).flow.cachedIn(viewModelScope)

    private fun getDefaultPagingConfig(): PagingConfig =
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        )
}