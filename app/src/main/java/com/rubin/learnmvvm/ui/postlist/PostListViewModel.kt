package com.rubin.learnmvvm.ui.postlist

import android.util.Log
import com.rubin.learnmvvm.core.BaseViewModel
import com.rubin.learnmvvm.data.remote.api.ApiService
import com.rubin.learnmvvm.data.remote.domain.Post
import com.rubin.learnmvvm.extension.with
import com.rubin.learnmvvm.util.NotNullMutableLiveData

class PostListViewModel(private val service: ApiService) : BaseViewModel() {

    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<List<Post>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<Post>>
        get() = _items

    fun getPostList() {
        addToDisposable(
            service.getPosts().with()
                .doOnSubscribe { refreshing.value = true }
                .doOnSuccess { refreshing.value = false }
                .doOnError { refreshing.value = false }
                .subscribe({
                    _items.value = it
                }, { error ->
                    Log.e("ERROR", error.message.toString())
                })
        )
    }
}