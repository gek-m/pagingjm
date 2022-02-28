package com.interview.pagingjm.network.reddit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.interview.pagingjm.R
import com.interview.pagingjm.network.domain.ApiChildren

class PagingAdapter: PagingDataAdapter<ApiChildren, PostViewHolder>(PostDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_reddit_post, parent, false)
        )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

}