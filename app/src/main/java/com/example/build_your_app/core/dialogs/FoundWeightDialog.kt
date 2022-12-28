package com.example.build_your_app.core.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.build_your_app.R

class FoundWeightDialog(private val weight: String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.your_weight, weight))
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                findNavController().popBackStack()
            }
            .create()

    companion object {
        const val TAG = "FoundWeightDialog"
    }
}