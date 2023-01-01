package com.example.build_your_app.core.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.build_your_app.R
import com.example.build_your_app.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment() {

    private val viewModelHomeScreen : HomeScreenViewModel by viewModels()
    private lateinit var binding : FragmentHomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@HomeScreenFragment
            viewModel = viewModelHomeScreen
            weightGuesserCv.setOnClickListener {
                goToWeightGuesser()
            }
            batteryCv.setOnClickListener {
                goToBatteryMeter()
            }
            lightCheckerCv.setOnClickListener {
                goToLightDetector()
            }
        }
        return binding.root
    }

    private fun goToWeightGuesser() {
        findNavController().navigate(R.id.action_home_screen_fragment_to_weight_guesser_fragment)
    }

    private fun goToBatteryMeter() {
        findNavController().navigate(R.id.action_home_screen_fragment_to_battery_meter_fragment)
    }

    private fun goToLightDetector() {
        findNavController().navigate(R.id.action_home_screen_fragment_to_light_detector_fragment)
    }
}