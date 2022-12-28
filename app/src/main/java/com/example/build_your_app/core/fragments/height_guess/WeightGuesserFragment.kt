package com.example.build_your_app.core.fragments.height_guess

import com.example.build_your_app.core.dialogs.WrongWeightDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.build_your_app.core.Utils.hideKeyboard
import com.example.build_your_app.core.dialogs.FoundWeightDialog
import com.example.build_your_app.databinding.FragmentWeightGuesserBinding

class WeightGuesserFragment : Fragment() {

    private val viewModelGuessScreen : WeightGuesserViewModel by viewModels()
    private lateinit var binding : FragmentWeightGuesserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeightGuesserBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = viewModelGuessScreen
            lifecycleOwner = this@WeightGuesserFragment
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
            submitButton.setOnClickListener {
                weightBar.text.toString().toIntOrNull()?.let {
                    hideKeyboard()
                    weightBar.clearFocus()
                    viewModelGuessScreen.progressAnimation(progress) {
                        dialogWeightShow()
                    }
                } ?: run {
                    invalidInputDialog()
                    weightBar.text.clear()
                }
            }
        }
        return binding.root
    }

    private fun invalidInputDialog() {
        WrongWeightDialog().show(
            childFragmentManager, WrongWeightDialog.TAG)
    }

    private fun dialogWeightShow() {
        FoundWeightDialog(binding.weightBar.text.toString()).show(
            childFragmentManager, FoundWeightDialog.TAG)
    }
}