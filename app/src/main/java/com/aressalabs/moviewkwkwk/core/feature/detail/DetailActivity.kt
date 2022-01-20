package com.aressalabs.moviewkwkwk.core.feature.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aressalabs.moviewkwkwk.R
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var movieDetail: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.getParcelableExtra<MovieModel>("movie").also {
            if (it != null) {
                movieDetail = it
            }
        }
        tvDetailTitle.text = movieDetail.original_title

    }
}