package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixtureResponse(

    @SerializedName("success") var success: Int? = null,
    @SerializedName("result") var result: ArrayList<FixturesResult> = arrayListOf()

): Parcelable
