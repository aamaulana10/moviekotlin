package com.aressalabs.moviewkwkwk.core.feature.detail

import android.net.Uri
import android.net.Uri.parse
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.aressalabs.moviewkwkwk.R
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.feature.detail.viewModel.DetailViewModel
import com.aressalabs.moviewkwkwk.core.feature.detail.viewModel.DetailViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var factory: DetailViewModelFactory
    private lateinit var movieDetail: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        factory = DetailViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        intent.getParcelableExtra<MovieModel>("movie").also {
            if (it != null) {
                movieDetail = it
            }
        }
        tvDetailTitle.text = movieDetail.original_title
        tvDetailDesc.text = movieDetail.overview

        initPreview()

    }

    private fun initPreview() {

        viewModel.getMovieVideos(movieDetail.id).asLiveData()
            .observe(this, { model ->

                val url =
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4" // your URL here

                val mediaController = MediaController(this)
                mediaController.setAnchorView(videoPreview)
                val uri: Uri = parse(url)
                videoPreview.setMediaController(mediaController)
                videoPreview.setVideoURI(uri)
                videoPreview.requestFocus()
                videoPreview.start()

            })
    }
}