package com.naqswell.allfootball.screens.detail

import android.util.Log
import androidx.lifecycle.*
import com.naqswell.allfootball.data.entities.fixtures.FixturesResult
import com.naqswell.allfootball.data.entities.fixtures.StartingLineups
import com.naqswell.allfootball.networking.api.AllSportsApiService
import com.naqswell.allfootball.networking.usecases.FetchFixturesUseCase
import kotlinx.coroutines.launch

class DetailViewModel constructor(
    allSportsApiService: AllSportsApiService,
    fixture: FixturesResult
) :
    ViewModel() {
    private var fetchFixturesUseCase = FetchFixturesUseCase(allSportsApiService)

    private val _match = MutableLiveData<FixturesResult>().apply {
        value = fixture
    }
    val match: LiveData<FixturesResult> = _match

    private val _homePlayers = MutableLiveData<ArrayList<StartingLineups>>().apply {
        value = _match.value?.lineups?.homeTeam?.startingLineups
    }
    val homePlayers: LiveData<ArrayList<StartingLineups>> = _homePlayers


    fun getMatchesToday() {
        val timeZone = "Europe/Moscow"

        viewModelScope.launch {
            when (val result =
                fetchFixturesUseCase.fetchFixtures("2023-02-16", "2023-02-16", timeZone)) {
                is FetchFixturesUseCase.Result.Success -> {
                    for (el in result.result) {
                        if (el.eventKey == _match.value!!.eventKey) {
                            Log.d("$this@MainViewModel", "founded $el  ${_match.value!!.eventKey}")
                            _match.value = el
                        }
                    }
                    Log.d("$this@MainViewModel", "success + ${_match.value}")
                }
                is FetchFixturesUseCase.Result.Failure -> {
                    Log.d("$this@MainViewModel", "fail " + result.errorData)
                }
            }

        }
    }

    companion object {
        fun provideFactory(
            allSportsApiService: AllSportsApiService,
            fixture: FixturesResult
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                ): T {
                    return DetailViewModel(allSportsApiService, fixture) as T
                }
            }
    }
}