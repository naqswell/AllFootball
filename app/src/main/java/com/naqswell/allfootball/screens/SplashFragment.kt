package com.naqswell.allfootball.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.naqswell.allfootball.Constants
import com.naqswell.allfootball.allSportsApi
import com.naqswell.allfootball.databinding.FragmentSplashBinding
import com.naqswell.allfootball.screens.main.MainViewModel

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val sharedMainViewModel: MainViewModel by activityViewModels {
        MainViewModel.provideFactory(
            allSportsApi
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root.apply {
            sharedMainViewModel.getMatchesToday()

            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(SplashFragmentDirections.actionToMain())
            }, Constants.SPLASH_SCREEN_TIME)

        }
    }
}