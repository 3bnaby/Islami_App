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
    lateinit var binding : FragmentSebhaBinding
    var tasbehCounter =0
    var array = arrayOf("الحمدلله","الله اكبر","سبحان الله","لا اله الا الله")
    var i = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tasbehCounterBtn.text = array[i]
        countTasbeh ()

    }

    fun countTasbeh (){
        binding.tasbehCounterBtn.setOnClickListener {
            if (tasbehCounter < 33) {
                tasbehCounter++
                binding.tasbehCounterTv.text = tasbehCounter.toString()
                Log.d("changeTasbeh", "changeTasbeh:$tasbehCounter ")
            } else{
                tasbehCounter = 0
                if(i <= array.size){
                changeTasbeh()
                }
                else{
                    countTasbeh()
                }
            }
        }
    }
    fun changeTasbeh (){
        i++
        binding.tasbehCounterBtn.text = array[i]
                Log.d("tasbeh", "changeTasbeh:${binding.tasbehCounterBtn.text} ")

            }
        }


