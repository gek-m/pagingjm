package com.interview.pagingjm.network.reddit.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.interview.pagingjm.databinding.ViewRedditPostBinding
import com.interview.pagingjm.network.domain.ApiChildren

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding: ViewRedditPostBinding by viewBinding()

    fun bind(post: ApiChildren) {
        with(binding) {
            postTitle.text = post.data.title
            score.text = post.data.score.toString()
            messageQuantity.text = post.data.numComments.toString()
        }
    }
}