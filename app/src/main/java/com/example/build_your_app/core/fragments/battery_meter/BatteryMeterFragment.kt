package com.example.build_your_app.core.fragments.battery_meter

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.build_your_app.R
import com.example.build_your_app.databinding.FragmentBatteryMeterBinding


class BatteryMeterFragment : Fragment() {

    private val viewModel: BatteryMeterViewModel by viewModels()
    private lateinit var binding: FragmentBatteryMeterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBatteryMeterBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@BatteryMeterFragment
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
        displayBatteryLevel()
        return binding.root
    }

    private fun displayBatteryLevel() {
        val batteryIntent = requireActivity().registerReceiver(null,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        viewModel.displayProgressiveBattery(binding.progressBar, binding.textViewProgress,
            viewModel.getBatteryLevel(batteryIntent).toInt())
    }
}