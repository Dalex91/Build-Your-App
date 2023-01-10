package com.example.build_your_app.core.fragments.laboratory_work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.build_your_app.databinding.FragmentLaboratoryWorkBinding

class LaboratoryWorkFragment : Fragment() {

    private lateinit var binding : FragmentLaboratoryWorkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaboratoryWorkBinding.inflate(inflater, container, false)
        binding.pdfView.fromAsset("Documentation_Android_Project.pdf").load()
        return binding.root
    }

}