package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AwayTeam (

    @SerializedName("starting_lineups" ) var startingLineups : ArrayList<StartingLineups> = arrayListOf(),
    @SerializedName("substitutes"      ) var substitutes     : ArrayList<Substitutes>     = arrayListOf(),
    @SerializedName("coaches"          ) var coaches         : ArrayList<Coaches>         = arrayListOf(),
    @SerializedName("missing_players"  ) var missingPlayers  : ArrayList<String>          = arrayListOf()

): Parcelable
