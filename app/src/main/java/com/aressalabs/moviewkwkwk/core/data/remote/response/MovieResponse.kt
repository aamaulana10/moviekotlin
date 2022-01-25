package com.aressalabs.moviewkwkwk.core.data.remote.response

import android.os.Parcelable
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
): Parcelable