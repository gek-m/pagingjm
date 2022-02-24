package com.interview.pagingjm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.interview.pagingjm.databinding.MainFragmentBinding
import com.interview.pagingjm.network.reddit.adapter.PagingAdapter
import kotlinx.coroutines.flow.collectLatest

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()
    private val pagingAdapter = PagingAdapter()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postsList.adapter = pagingAdapter
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.posts.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }

}