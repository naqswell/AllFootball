package com.naqswell.allfootball.data.entities.fixtures

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixturesResult (

    @SerializedName("event_key"             ) var eventKey            : String?                = null,
    @SerializedName("event_date"            ) var eventDate           : String?                = null,
    @SerializedName("event_time"            ) var eventTime           : String?                = null,
    @SerializedName("event_home_team"       ) var eventHomeTeam       : String?                = null,
    @SerializedName("home_team_key"         ) var homeTeamKey         : String?                = null,
    @SerializedName("event_away_team"       ) var eventAwayTeam       : String?                = null,
    @SerializedName("away_team_key"         ) var awayTeamKey         : String?                = null,
    @SerializedName("event_halftime_result" ) var eventHalftimeResult : String?                = null,
    @SerializedName("event_final_result"    ) var eventFinalResult    : String?                = null,
    @SerializedName("event_ft_result"       ) var eventFtResult       : String?                = null,
    @SerializedName("event_penalty_result"  ) var eventPenaltyResult  : String?                = null,
    @SerializedName("event_status"          ) var eventStatus         : String?                = null,
    @SerializedName("country_name"          ) var countryName         : String?                = null,
    @SerializedName("league_name"           ) var leagueName          : String?                = null,
    @SerializedName("league_key"            ) var leagueKey           : String?                = null,
    @SerializedName("league_round"          ) var leagueRound         : String?                = null,
    @SerializedName("league_season"         ) var leagueSeason        : String?                = null,
    @SerializedName("event_live"            ) var eventLive           : String?                = null,
    @SerializedName("event_stadium"         ) var eventStadium        : String?                = null,
    @SerializedName("event_referee"         ) var eventReferee        : String?                = null,
    @SerializedName("home_team_logo"        ) var homeTeamLogo        : String?                = null,
    @SerializedName("away_team_logo"        ) var awayTeamLogo        : String?                = null,
    @SerializedName("event_country_key"     ) var eventCountryKey     : String?                = null,
    @SerializedName("league_logo"           ) var leagueLogo          : String?                = null,
    @SerializedName("country_logo"          ) var countryLogo         : String?                = null,
    @SerializedName("event_home_formation"  ) var eventHomeFormation  : String?                = null,
    @SerializedName("event_away_formation"  ) var eventAwayFormation  : String?                = null,
    @SerializedName("fk_stage_key"          ) var fkStageKey          : String?                = null,
    @SerializedName("stage_name"            ) var stageName           : String?                = null,
    @SerializedName("league_group"          ) var leagueGroup         : String?                = null,
//    @SerializedName("goalscorers"           ) var goalscorers         : ArrayList<Map<String?, String?>>      = arrayListOf(
//        mapOf()),
//    @SerializedName("substitutes"           ) var substitutes         : ArrayList<Substitutes> = arrayListOf(),
//    @SerializedName("cards"                 ) var cards               : ArrayList<Cards>       = arrayListOf(),
    @SerializedName("lineups"               ) var lineups             : Lineups?               = Lineups(),
//    @SerializedName("statistics"            ) var statistics          : ArrayList<Statistics>  = arrayListOf()

): Parcelable
