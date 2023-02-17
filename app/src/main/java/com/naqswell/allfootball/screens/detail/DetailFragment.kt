package com.naqswell.allfootball.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.naqswell.allfootball.allSportsApi
import com.naqswell.allfootball.data.entities.fixtures.FixturesResult
import com.naqswell.allfootball.databinding.FragmentDetailBinding
import com.naqswell.allfootball.screens.main.MatchesAdapter

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModels {
        DetailViewModel.provideFactory(allSportsApi, args.fixture)
    }
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var onCreateFixture: FixturesResult

    private lateinit var recyclerView: RecyclerView
    private lateinit var detailAdapter: DetailAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onCreateFixture = args.fixture

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root.apply {
            loadImages(onCreateFixture)
            initTextViews(onCreateFixture)

            recyclerView = binding.rvPlayers
            recyclerView.layoutManager = LinearLayoutManager(context)

            detailViewModel.homePlayers.observe(viewLifecycleOwner) { players ->
                detailAdapter = DetailAdapter(players)
                recyclerView.adapter = detailAdapter
            }

            swipeRefreshLayout = binding.swipeRefreshDetail
            swipeRefreshLayout.setOnRefreshListener {
                detailViewModel.getMatchesToday()
                swipeRefreshLayout.isRefreshing = false
            }

            detailViewModel.match.observe(viewLifecycleOwner) { fixture->
                loadImages(fixture)
                initTextViews(fixture)
            }
        }
    }

    private fun initTextViews(fixturesResult: FixturesResult) {
        with(binding) {

            txtLeagueName.text = fixturesResult.leagueName!!.uppercase()
            txtCountryName.text = fixturesResult.countryName!!.uppercase()

            imgCountry.apply {
                if (fixturesResult.countryLogo == null) {
                    imgCountry.visibility = View.INVISIBLE
                }
            }

            txtHomeTeam.text = fixturesResult.eventHomeTeam
            txtAwayTeam.text = fixturesResult.eventAwayTeam

            txtEventFinalResult.apply {
                text = when (val time = fixturesResult.eventFinalResult) {
                    "-" -> {
                        "Not played"
                    }
                    else -> time
                }
            }
            txtEventTime.text = fixturesResult.eventTime
        }
    }

    private fun loadImages(fixture: FixturesResult) {
        with(binding) {
            Glide.with(imgHomeTeam.context)
                .load(fixture.homeTeamLogo)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgHomeTeam)

            Glide.with(imgAwayTeam.context)
                .load(fixture.awayTeamLogo)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgAwayTeam)

            Glide.with(imgCountry.context)
                .load(fixture.countryLogo)
                .fitCenter()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgCountry)
        }
    }

    companion object {
        fun newInstance() = DetailFragment()
    }
}