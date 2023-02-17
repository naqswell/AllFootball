package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cards (

    @SerializedName("time"       ) var time      : String? = null,
    @SerializedName("home_fault" ) var homeFault : String? = null,
    @SerializedName("card"       ) var card      : String? = null,
    @SerializedName("away_fault" ) var awayFault : String? = null

): Parcelable
