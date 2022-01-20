package com.aressalabs.moviewkwkwk.core.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aressalabs.moviewkwkwk.R
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_latest_item.view.*

class LatestAdapter(private val movies: List<MovieModel>): RecyclerView.Adapter<LatestAdapter.LatestViewHolder>() {

    inner class LatestViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val baseImage = "https://image.tmdb.org/t/p/w500/"

        fun bindViewHolder(movieModel: MovieModel) {

            Glide.with(itemView)
                .load(baseImage + movieModel.poster_path)
                .into(itemView.movie_latest_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {

        return LatestViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_latest_item, parent, false))
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        holder.bindViewHolder(movies[position])
    }

    override fun getItemCount(): Int {
        
        return movies.size
    }
}

