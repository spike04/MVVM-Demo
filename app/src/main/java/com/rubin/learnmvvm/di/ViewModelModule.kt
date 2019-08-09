package com.rubin.learnmvvm.di

import com.rubin.learnmvvm.ui.postlist.PostListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostListViewModel(get()) }
}