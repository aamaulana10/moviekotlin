package com.aressalabs.moviewkwkwk.core.feature.home.router

import android.content.Context
import android.content.Intent
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.feature.detail.DetailActivity

class HomeRouter {

    fun navigateToDetail(context: Context, movie: MovieModel) {

        val intent = Intent(context, DetailActivity::class.java)

        intent.putExtra("movie", movie)

        context.startActivity(intent);

    }
}