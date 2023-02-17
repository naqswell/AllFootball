package com.naqswell.allfootball.screens.main

import android.util.Log
import androidx.lifecycle.*
import com.naqswell.allfootball.data.entities.fixtures.FixturesResult
import com.naqswell.allfootball.networking.api.AllSportsApiService
import com.naqswell.allfootball.networking.usecases.FetchFixturesUseCase
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel constructor(allSportsApiService: AllSportsApiService) :
    ViewModel() {
    private var fetchFixturesUseCase = FetchFixturesUseCase(allSportsApiService)

    private val _matchesTodayList = MutableLiveData<ArrayList<FixturesResult>>().apply {
        value = arrayListOf()
    }
    val matchesTodayList: LiveData<ArrayList<FixturesResult>> = _matchesTodayList

    fun getMatchesToday() {
        val timeZone = "Europe/Moscow"

        viewModelScope.launch {
            when (val result =
                fetchFixturesUseCase.fetchFixtures("2023-02-16", "2023-02-16", timeZone)) {
                is FetchFixturesUseCase.Result.Success -> {
                    _matchesTodayList.value = result.result
                    Log.d("$this@MainViewModel", "success + ${_matchesTodayList.value}")
                }
                is FetchFixturesUseCase.Result.Failure -> {
                    Log.d("$this@MainViewModel", "fail " + result.errorData)
                }
            }

        }
    }

    companion object {
        fun provideFactory(allSportsApiService: AllSportsApiService): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                ): T {
                    return MainViewModel(
                        allSportsApiService
                    ) as T
                }
            }
    }
}