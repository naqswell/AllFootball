package com.naqswell.allfootball

import android.app.Application
import androidx.annotation.UiThread
import com.naqswell.allfootball.networking.api.AllSportsApiService

lateinit var allSportsApi: AllSportsApiService

@UiThread
class MyApplication: Application() {
    override fun onCreate() {
        allSportsApi = AllSportsApiService.apiService
        super.onCreate()
    }
}