package com.aressalabs.moviewkwkwk.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieVideosResponse(
    val id: Int,
    val results: List<MovieVideosModel>
) : Parcelable

@Parcelize
data class MovieVideosModel(
    val id: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val site: String,
    val size: Int,
    val type: String
): Parcelable