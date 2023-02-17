package com.naqswell.allfootball.networking.api

import com.naqswell.allfootball.BuildConfig
import com.naqswell.allfootball.Constants.ALLSPORTS_BASE_URL
import com.naqswell.allfootball.data.entities.fixtures.FixtureResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AllSportsApiService {

    @GET("?met=Fixtures")
    suspend fun getFixtures(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("timezone") timezone: String?,
        @Query("countryId") countryId: String?,
        @Query("leagueId") leagueId: String?,
        @Query("matchId") matchId: Int?,
        @Query("matchId") teamId: Int?,
        @Query("leagueGroup") leagueGroup: Int?,
    ): Response<FixtureResponse>

    @GET("?met=Fixtures")
    suspend fun getFixtures(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("timezone") timezone: String?,
    ): Response<FixtureResponse>

    companion object {
        private val loggingInterceptor =
            HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) };
        ;

        private val okHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor(ApiInterceptor(BuildConfig.ALLSPORTS_API_KEY))
                .addInterceptor(loggingInterceptor)
                .build()
        }

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(ALLSPORTS_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val apiService: AllSportsApiService by lazy {
            retrofit.create(AllSportsApiService::class.java)
                ?: throw IllegalStateException("ApiService must be initialized")
        }

    }
}