package com.naqswell.allfootball.screens.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.naqswell.allfootball.BuildConfig
import com.naqswell.allfootball.Constants.WEB_VIEW
import com.naqswell.allfootball.databinding.FragmentWebBinding
import com.onesignal.OneSignal

class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(requireContext())
        OneSignal.setAppId(BuildConfig.ONESIGNAL_APP_ID)

        _binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root.apply {
            binding.webView.loadUrl(WEB_VIEW)
        }
    }
}