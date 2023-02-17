package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubstitutesScorer  (

    @SerializedName("player"          ) var player         : String? = null,
    @SerializedName("player_number"   ) var playerNumber   : String? = null,
    @SerializedName("player_position" ) var playerPosition : String? = null,
    @SerializedName("player_country"  ) var playerCountry  : String? = null,
    @SerializedName("player_key"      ) var playerKey      : String? = null

): Parcelable
