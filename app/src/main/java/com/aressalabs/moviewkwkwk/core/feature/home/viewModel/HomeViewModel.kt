package com.aressalabs.moviewkwkwk.core.feature.home.viewModel

import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosModel
import com.aressalabs.moviewkwkwk.core.domain.useCase.UseCase
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.Flow

class HomeViewModel(useCase: UseCase) : ViewModel() {

    val popularMovies = useCase.loadPopularMovies().asLiveData()
    val upComingMovies = useCase.loadUpcomingMovies().asLiveData()
    val nowPlayingMovies = useCase.loadNowPlayingMovies().asLiveData()

    fun setBanner(imageView: ImageView, movieModel: MovieModel) {

        val baseImage = "https://image.tmdb.org/t/p/w500/"

        Glide.with(imageView)
            .load(baseImage + movieModel.poster_path)
            .into(imageView)
    }

    fun setDataBottomSheet(
        imageView: ImageView,
        title: TextView,
        desc: TextView,
        movieModel: MovieModel
    ) {

        val baseImage = "https://image.tmdb.org/t/p/w500/"

        Glide.with(imageView)
            .load(baseImage + movieModel.poster_path)
            .into(imageView)

        title.text = movieModel.original_title
        desc.text = movieModel.overview
    }

    fun setDataBottomMenuSheet(
        title: TextView,
        movieModel: MovieModel
    ) {

        title.text = movieModel.original_title
    }
}