package com.aressalabs.moviewkwkwk.core.feature.detail.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aressalabs.moviewkwkwk.core.di.Injection
import com.aressalabs.moviewkwkwk.core.domain.useCase.UseCase

class DetailViewModelFactory private constructor(private val useCase: UseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: DetailViewModelFactory? = null

        fun getInstance(context: Context): DetailViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: DetailViewModelFactory(
                    Injection.provideUseCase(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(useCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}