package com.example.islami_app.ui.screens.home.tabs.ahadeth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami_app.R
import com.example.islami_app.databinding.FragmentAhadethBinding
import com.example.islami_app.databinding.FragmentQuraanBinding



class AhadethFragment : Fragment() {

    lateinit var binding : FragmentAhadethBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAhadethBinding.inflate(inflater,container,false)
        return binding.root
    }
}