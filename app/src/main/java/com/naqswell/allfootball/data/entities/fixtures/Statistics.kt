package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Statistics (

    @SerializedName("type" ) var type : String? = null,
    @SerializedName("home" ) var home : String? = null,
    @SerializedName("away" ) var away : String? = null

): Parcelable
