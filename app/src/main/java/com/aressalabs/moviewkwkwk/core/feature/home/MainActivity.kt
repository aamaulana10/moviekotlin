package com.aressalabs.moviewkwkwk.core.feature.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aressalabs.moviewkwkwk.R
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.feature.home.`interface`.IMovieRecyclerListener
import com.aressalabs.moviewkwkwk.core.feature.home.adapter.LatestAdapter
import com.aressalabs.moviewkwkwk.core.feature.home.adapter.PopularAdapter
import com.aressalabs.moviewkwkwk.core.feature.home.adapter.UpcomingAdapter
import com.aressalabs.moviewkwkwk.core.feature.home.router.HomeRouter
import com.aressalabs.moviewkwkwk.core.feature.home.viewModel.HomeViewModel
import com.aressalabs.moviewkwkwk.core.feature.home.viewModel.HomeViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_bottom_sheet.*

class MainActivity : AppCompatActivity(), IMovieRecyclerListener {

    private lateinit var popularAdapter: PopularAdapter
    private lateinit var latestAdapter: LatestAdapter
    private lateinit var upcomingAdapter: UpcomingAdapter
    private lateinit var viewModel: HomeViewModel
    private var router : HomeRouter = HomeRouter()
    private lateinit var bottomSheet : BottomSheetDialog
    private lateinit var factory : HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        factory = HomeViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        bottomSheet = BottomSheetDialog(this)
        bottomSheet.setContentView(R.layout.movie_bottom_sheet)

        initPopular()
        initUpComing()
        initLatest()

    }

    private fun initPopular() {

        rvPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.popularMovies.observe(this, { model ->

            if (model != null) {

                popularAdapter = PopularAdapter(model, this)
                rvPopular.adapter = popularAdapter
                viewModel.setBanner(movieBanner, model.first())
            }
        })
    }

    private fun initUpComing() {
        rvUpcoming.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        viewModel.upComingMovies.observe(this, { model ->

            if (model != null) {

                upcomingAdapter = UpcomingAdapter(model)
                rvUpcoming.adapter = upcomingAdapter
            }
        })

    }

    private fun initLatest() {
        rvLatest.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        viewModel.nowPlayingMovies.observe(this, { model ->

            if (model != null) {

                latestAdapter = LatestAdapter(model)
                rvLatest.adapter = latestAdapter
            }
        })

    }

    override fun onItemClicked(view: View, movie: MovieModel) {

        router.navigateToDetail(this,movie)
    }

    override fun onInfoClicked(view: View, movie: MovieModel) {

        Log.d("response success ", movie.original_title.toString())

        bottomSheet.show()

        viewModel.setDataBottomSheet(bottomSheet.imageBottom, bottomSheet.titleBottom, bottomSheet.descBottom, movie)

    }
}