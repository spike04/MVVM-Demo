package com.rubin.learnmvvm.ui.postlist

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rubin.learnmvvm.data.remote.domain.Post

@BindingAdapter("postList")
fun setPostList(view: RecyclerView, items: List<Post>) {
    view.adapter?.run {
        if (this is PostListAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        PostListAdapter(items).apply { view.adapter = this }
    }
}