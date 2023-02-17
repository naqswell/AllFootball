package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lineups (

    @SerializedName("home_team" ) var homeTeam : HomeTeam? = HomeTeam(),
    @SerializedName("away_team" ) var awayTeam : AwayTeam? = AwayTeam()

): Parcelable
