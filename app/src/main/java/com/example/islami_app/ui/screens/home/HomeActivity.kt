package com.example.islami_app.ui.screens.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami_app.R
import com.example.islami_app.databinding.ActivityHomeBinding
import com.example.islami_app.ui.screens.home.tabs.ahadeth.AhadethFragment
import com.example.islami_app.ui.screens.home.tabs.quraan.QuraanFragment
import com.example.islami_app.ui.screens.home.tabs.radio.RadioFragment
import com.example.islami_app.ui.screens.home.tabs.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(QuraanFragment())
        initListeners()
    }

    private fun initListeners(){
        binding.bottomNavView.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.quraan_item -> {
                    showFragment(QuraanFragment())
                }
                R.id.sebha_item -> {
                    showFragment(SebhaFragment())

                }
                R.id.radio_item -> {
                    showFragment(RadioFragment())

                }
                R.id.ahadeth_item -> {
                    showFragment(AhadethFragment())

                }
                else -> {

                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container , fragment)
            .commit()
    }
}