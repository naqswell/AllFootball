package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coaches (

    @SerializedName("coache"         ) var coache        : String? = null,
    @SerializedName("coache_country" ) var coacheCountry : String? = null

): Parcelable
