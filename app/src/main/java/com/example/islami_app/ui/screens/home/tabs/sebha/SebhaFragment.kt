package com.example.islami_app.ui.screens.home.tabs.sebha

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami_app.R
import com.example.islami_app.databinding.FragmentQuraanBinding
import com.example.islami_app.databinding.FragmentSebhaBinding
import kotlin.math.log


class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    lateinit var azkarList: MutableList<String>
    var tasbehCounter = 0
    var currentIndex = 0
    var currentRotation = 0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.zekrTv.text = azkarList[0]
        onSebhaClick()

    }

    fun onSebhaClick() {
        binding.sebhaLogo.setOnClickListener {
            rotateSebha()
            if (tasbehCounter < 33) {
                tasbehCounter++
            } else {
              changeZekr()
            }
            binding.tasbehCounterTv.text = tasbehCounter.toString()
        }

    }
    fun rotateSebha(){
        currentRotation += (-360/33)
        binding.sebhaLogo.rotation = currentRotation.toFloat()
    }

    fun changeZekr() {
        tasbehCounter = 0
        currentIndex = if (currentIndex < azkarList.size - 1)++currentIndex else 0
        binding.zekrTv.text = azkarList[currentIndex]
    }

}

