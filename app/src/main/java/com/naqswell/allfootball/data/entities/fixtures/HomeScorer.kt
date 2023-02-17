package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeScorer (

    @SerializedName("in"  ) var inParam  : String? = null,
    @SerializedName("out" ) var outparam : String? = null

): Parcelable