package com.example.islami_app.ui.screens.home.tabs.quraan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami_app.databinding.ItemChapterBinding
import com.example.islami_app.ui.model.Chapter

class ChaptersAdapter(val chapters : List<Chapter> , val onChapterClick : (Chapter,Int) -> Unit) :
    Adapter<ChaptersAdapter.ChaptersViewHolder>() {



    class ChaptersViewHolder(val binding:ItemChapterBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewHolder {
        val binding = ItemChapterBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ChaptersViewHolder(binding)
    }

    override fun getItemCount(): Int = chapters.size

    override fun onBindViewHolder(holder: ChaptersViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.binding.chapterNameTv.text = chapter.name
        holder.binding.chapterVersesTv.text= chapter.versesNumber.toString()
        holder.binding.root.setOnClickListener{
            onChapterClick(chapter,position)
        }
    }
}
