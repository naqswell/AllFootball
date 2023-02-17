package com.naqswell.allfootball.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.naqswell.allfootball.allSportsApi
import com.naqswell.allfootball.data.entities.fixtures.FixturesResult
import com.naqswell.allfootball.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val sharedMainViewModel: MainViewModel by activityViewModels {
        MainViewModel.provideFactory(allSportsApi)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var matchesAdapter: MatchesAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var onRvItemClicked: (fixture: FixturesResult) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root.apply {

            swipeRefreshLayout = binding.swipeRefresh
            swipeRefreshLayout.setOnRefreshListener {
                sharedMainViewModel.getMatchesToday()
                swipeRefreshLayout.isRefreshing = false
            }

            recyclerView = binding.rvMatches
            recyclerView.layoutManager = LinearLayoutManager(context)

            onRvItemClicked = { fixture ->
                findNavController().navigate(
                    MainFragmentDirections.actionToDetail(fixture)
                )
            }

            sharedMainViewModel.matchesTodayList.observe(viewLifecycleOwner) { fixtures ->
                matchesAdapter = MatchesAdapter(fixtures) {}
                recyclerView.adapter = MatchesAdapter(fixtures) { result ->
                    onRvItemClicked(result)
                }
            }


            binding.btnWebView.setOnClickListener {
                findNavController().navigate(MainFragmentDirections.actionToWeb())
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}