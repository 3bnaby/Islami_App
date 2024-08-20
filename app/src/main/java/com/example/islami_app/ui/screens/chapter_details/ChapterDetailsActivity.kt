package com.example.islami_app.ui.screens.chapter_details

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami_app.R
import com.example.islami_app.databinding.ActivityChapterDetailsBinding
import com.example.islami_app.ui.screens.home.tabs.quraan.QuraanFragment
import java.io.BufferedReader
import java.io.InputStreamReader

class ChapterDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityChapterDetailsBinding

    lateinit var fileName :String
    lateinit var suraName :String

    var chapterContent = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fileName = intent.getStringExtra(QuraanFragment.FILE_NAME)!!
        suraName =intent.getStringExtra(QuraanFragment.SURA_NAME)!!
        readFile()
        binding.chapterContentTv.text = chapterContent


    }
    private fun readFile() {
        val reader = BufferedReader(
            InputStreamReader(assets.open("quraan/$fileName"), "UTF-8")
        )
        var mLine: String?
        var verseNumber = 1
        mLine = reader.readLine()
        while (mLine != null) {
            chapterContent += mLine + "{${verseNumber}}"
            mLine = reader.readLine()
            verseNumber++
        }
    }
}