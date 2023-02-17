package com.naqswell.allfootball.networking.usecases

import android.util.Log
import com.naqswell.allfootball.data.entities.fixtures.FixturesResult
import com.naqswell.allfootball.networking.api.AllSportsApiService
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchFixturesUseCase(private val allSportsApiService: AllSportsApiService) {

    sealed class Result {
        class Success(val result: ArrayList<FixturesResult>) : Result()
        class Failure(val errorData: String) : Result()
    }

    suspend fun fetchFixtures(
        from: String,
        to: String,
        timezone: String?,
    ): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = allSportsApiService.getFixtures(
                    from,
                    to,
                    timezone
                )
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!.result)
                } else {
                    return@withContext Result.Failure(response.errorBody().toString())
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    Log.d("$this cancellationException", t.message!!)
                    return@withContext Result.Failure("cancellationException")
                } else {
                    throw t
                }
            }
        }
    }

    suspend fun fetchFixtures(
        from: String,
        to: String,
        timezone: String?,
        countryId: String?,
        leagueId: String?,
        matchId: Int?,
        teamId: Int?,
        leagueGroup: Int?,
    ): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = allSportsApiService.getFixtures(
                    from,
                    to,
                    timezone,
                    countryId,
                    leagueId,
                    matchId,
                    teamId,
                    leagueGroup
                )
                Log.d("RESPONSE_LOG", response.toString())
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!.result)
                } else {
                    return@withContext Result.Failure(response.errorBody().toString())
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure("cancellationException")
                } else {
                    throw t
                }
            }
        }
    }
}