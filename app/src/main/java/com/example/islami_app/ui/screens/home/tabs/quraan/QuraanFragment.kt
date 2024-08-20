package com.example.islami_app.ui.screens.home.tabs.quraan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami_app.R
import com.example.islami_app.databinding.FragmentQuraanBinding
import com.example.islami_app.ui.screens.chapter_details.ChapterDetailsActivity
import com.example.islami_app.ui.utilis.Constants

class QuraanFragment : Fragment() {
    lateinit var binding : FragmentQuraanBinding
    lateinit var chaptersAdapter : ChaptersAdapter

    companion object{
        const val FILE_NAME = "file_name"
        const val SURA_NAME = "SURA_NAME"
    }

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
        chaptersAdapter = ChaptersAdapter(Constants.chapters){ chapter, index ->

            val intent = Intent(requireActivity() , ChapterDetailsActivity::class.java)
            startActivity(intent)
            intent.putExtra( FILE_NAME , chapter.name)
            intent.putExtra( SURA_NAME , "${index + 1}.txt")


        }
        binding.chaptersRv.adapter = chaptersAdapter
    }
}
