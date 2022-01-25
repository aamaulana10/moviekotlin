package com.aressalabs.moviewkwkwk.core.feature.detail.viewModel

import androidx.lifecycle.ViewModel
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosModel
import com.aressalabs.moviewkwkwk.core.domain.useCase.UseCase
import kotlinx.coroutines.flow.Flow

class DetailViewModel(private val useCase: UseCase) : ViewModel() {

    fun getMovieVideos(id: Int) : Flow<List<MovieVideosModel>> {

        return useCase.loadMovieVideo(id)
    }

}