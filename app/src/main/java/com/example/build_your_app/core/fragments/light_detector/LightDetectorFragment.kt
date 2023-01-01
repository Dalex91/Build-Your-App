package com.example.build_your_app.core.fragments.light_detector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.build_your_app.R
import com.example.build_your_app.core.utils.LightSensor
import com.example.build_your_app.databinding.FragmentLightDetectorBinding

class LightDetectorFragment : Fragment() {

    private lateinit var binding: FragmentLightDetectorBinding
    private val viewModelLightSensor: LightDetectorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLightDetectorBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@LightDetectorFragment
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
        viewModelLightSensor.lightSensor = context?.let { LightSensor(it) }
        viewModelLightSensor.observeLightSensor()
        handleSensorResponse()
        return binding.root
    }

    fun handleSensorResponse() {
        viewModelLightSensor.isDark.observe(viewLifecycleOwner) {
            when (viewModelLightSensor.isDark.value) {
                true -> {
                    binding.layoutCl.setBackgroundColor(
                        ResourcesCompat.getColor(
                            resources,
                            R.color.shark,
                            null
                        )
                    )
                    binding.titleImageTv.text = getString(R.string.dark_outside)
                    binding.iconSunIv.setImageDrawable(context?.let {
                        ContextCompat.getDrawable(
                            it,
                            R.drawable.ic_moon_regular
                        )
                    })
                    binding.titleImageTv.setTextColor(
                        ResourcesCompat.getColor(
                            resources,
                            R.color.moon,
                            null
                        )
                    )
                }
                false -> {
                    binding.layoutCl.setBackgroundColor(
                        ResourcesCompat.getColor(
                            resources,
                            R.color.white,
                            null
                        )
                    )
                    binding.titleImageTv.text = getString(R.string.bright_outside)
                    binding.iconSunIv.setImageDrawable(context?.let {
                        ContextCompat.getDrawable(
                            it,
                            R.drawable.ic_sun_regular
                        )
                    })
                    binding.titleImageTv.setTextColor(
                        ResourcesCompat.getColor(
                            resources,
                            R.color.sun,
                            null
                        )
                    )
                }
                else -> {}
            }
        }
    }
}