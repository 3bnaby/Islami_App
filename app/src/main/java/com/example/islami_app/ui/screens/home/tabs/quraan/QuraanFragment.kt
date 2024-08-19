package com.example.islami_app.ui.screens.home.tabs.quraan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami_app.R
import com.example.islami_app.databinding.FragmentQuraanBinding
import com.example.islami_app.ui.utilis.Constants

class QuraanFragment : Fragment() {
    lateinit var binding : FragmentQuraanBinding
    lateinit var chaptersAdapter : ChaptersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuraanBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChaptersRecyclerView()
    }

    private fun initChaptersRecyclerView() {
        chaptersAdapter = ChaptersAdapter(Constants.chapters)
        binding.chaptersRv.adapter = chaptersAdapter
    }
}
