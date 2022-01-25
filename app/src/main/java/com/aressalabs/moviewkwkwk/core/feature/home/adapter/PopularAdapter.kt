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
import java.util.ArrayList

class PopularAdapter
    : RecyclerView.Adapter<PopularAdapter.MovieViewHolder>() {

    private var movies = ArrayList<MovieModel>()
    lateinit var listener: IMovieRecyclerListener

    fun setData(newListData: List<MovieModel>?) {
        if (newListData == null) return
        movies.clear()
        movies.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val baseImage = "https://image.tmdb.org/t/p/w500/"

        fun bindViewHolder(movie: MovieModel) {

            Glide.with(itemView).load(baseImage + movie.poster_path)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_latest_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       holder.bindViewHolder(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
