package com.interview.pagingjm.network.reddit.adapter

import androidx.recyclerview.widget.DiffUtil
import com.interview.pagingjm.network.domain.ApiChildren

object PostDiffUtil: DiffUtil.ItemCallback<ApiChildren>() {
    override fun areItemsTheSame(oldItem: ApiChildren, newItem: ApiChildren): Boolean {
        return oldItem.data.id == newItem.data.id
    }

    override fun areContentsTheSame(oldItem: ApiChildren, newItem: ApiChildren): Boolean {
        return oldItem == newItem
    }
}