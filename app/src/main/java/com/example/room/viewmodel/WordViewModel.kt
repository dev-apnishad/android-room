package com.example.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.db.WordDatabase
import com.example.room.db.entity.Word
import com.example.room.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val wordRepository: WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordDao = WordDatabase.getDatabase(application).wordDao()
        wordRepository = WordRepository(wordDao);
        allWords = wordRepository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        wordRepository.insert(word)
    }
}