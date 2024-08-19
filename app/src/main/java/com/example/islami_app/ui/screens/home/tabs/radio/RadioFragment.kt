package com.example.islami_app.ui.screens.home.tabs.radio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami_app.R
import com.example.islami_app.databinding.FragmentQuraanBinding
import com.example.islami_app.databinding.FragmentRadioBinding


class RadioFragment : Fragment() {

    lateinit var binding : FragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioBinding.inflate(inflater,container,false)
        return binding.root
    }
}