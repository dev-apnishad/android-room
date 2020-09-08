package com.example.room.repository

import androidx.lifecycle.LiveData
import com.example.room.db.dao.WordDao
import com.example.room.db.entity.Word

class WordRepository(private val dao: WordDao) {
    val allWords: LiveData<List<Word>> = dao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        dao.insert(word)
    }
}