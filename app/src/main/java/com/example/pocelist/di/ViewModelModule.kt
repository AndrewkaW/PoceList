package com.example.pocelist.di

import com.example.pocelist.presentation.details.view_model.PocemonDetailsViewModel
import com.example.pocelist.presentation.list.view_model.PocemonsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        PocemonsListViewModel(get())
    }

    viewModel {
        PocemonDetailsViewModel(get())
    }

}
