package com.example.room.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.db.entity.Word

class WordAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context);
    private var words = emptyList<Word>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvWord: TextView = itemView.findViewById(R.id.tvWord)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_word, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = words[position]
        holder.tvWord.setText(current.word)
    }

    override fun getItemCount() = words.size

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }
}