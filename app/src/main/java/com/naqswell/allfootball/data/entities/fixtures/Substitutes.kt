package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Substitutes(

    @SerializedName("time") var time: String? = null,
    @SerializedName("home_scorer") var homeScorer: ArrayList<HomeScorer?> = arrayListOf(),
    @SerializedName("score") var score: String? = null,
    @SerializedName("away_scorer") var awayScorer: ArrayList<String> = arrayListOf()

): Parcelable
