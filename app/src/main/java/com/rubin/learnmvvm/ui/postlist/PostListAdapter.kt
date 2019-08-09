package com.rubin.learnmvvm.ui.postlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rubin.learnmvvm.R
import com.rubin.learnmvvm.core.BaseViewHolder
import com.rubin.learnmvvm.data.remote.domain.Post
import com.rubin.learnmvvm.databinding.ItemPostBinding

class PostListAdapter(var items: List<Post> = arrayListOf()) :
    RecyclerView.Adapter<PostListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_post,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.binding.item = items[position]
    }

    override fun getItemCount() = items.count()
    class RepositoryViewHolder(view: View) : BaseViewHolder<ItemPostBinding>(view)
}