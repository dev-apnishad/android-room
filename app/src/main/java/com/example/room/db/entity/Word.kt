package com.example.room.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)