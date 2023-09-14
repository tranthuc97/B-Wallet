package com.mobiai.app.db.question

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id: Long = 0,
    @ColumnInfo(name ="question")
    val question: String,
    @ColumnInfo(name ="answer")
    val answer: String)