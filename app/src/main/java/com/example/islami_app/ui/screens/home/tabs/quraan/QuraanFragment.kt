package com.example.islami_app.ui.screens.home.tabs.quraan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami_app.R
import com.example.islami_app.databinding.FragmentQuraanBinding

class QuraanFragment : Fragment() {
    lateinit var binding : FragmentQuraanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuraanBinding.inflate(inflater,container,false)
        return binding.root
    }
}
