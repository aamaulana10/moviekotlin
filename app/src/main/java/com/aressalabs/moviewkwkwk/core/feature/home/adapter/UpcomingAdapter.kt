package com.aressalabs.moviewkwkwk.core.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aressalabs.moviewkwkwk.R
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.feature.home.interfaces.IMovieRecyclerListener
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_latest_item.view.*

class UpcomingAdapter(private val movies: List<MovieModel>, private val listener: IMovieRecyclerListener): RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {

        return UpcomingViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_latest_item, parent, false))
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.bindHolder(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class UpcomingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val baseImage = "https://image.tmdb.org/t/p/w500/"

        fun bindHolder(movie: MovieModel) {

            Glide.with(itemView)
                .load(baseImage + movie.poster_path)
                .into(itemView.movie_latest_image)

            itemView.setOnClickListener {
                listener.onItemClicked(it, movie)
            }

            itemView.btnInfo.setOnClickListener {
                listener.onInfoClicked(it, movie)
            }

            itemView.btnBottomMenu.setOnClickListener {
                listener.onMenuItemClicked(it, movie)
            }

            itemView.btnPlay.visibility = View.GONE
        }
    }
}