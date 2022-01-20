package com.aressalabs.moviewkwkwk.core.feature.home.`interface`

import android.view.View
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel

interface IMovieRecyclerListener {

    fun onItemClicked(view: View, movie: MovieModel)
    fun onInfoClicked(view: View, movie: MovieModel)
}