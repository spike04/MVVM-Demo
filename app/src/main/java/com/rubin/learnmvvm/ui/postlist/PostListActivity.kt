package com.rubin.learnmvvm.ui.postlist

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.rubin.learnmvvm.R
import com.rubin.learnmvvm.core.BaseActivity
import com.rubin.learnmvvm.databinding.ActivitySearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostListActivity : BaseActivity<ActivitySearchBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_search

    private val myViewModel: PostListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        binding.vm = myViewModel
        binding.lifecycleOwner = this

        myViewModel.getPostList()
    }
}
