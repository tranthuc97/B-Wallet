package com.mobiai.app.db.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id: Long = 0,
    @ColumnInfo(name ="title")
    val title: String,
    @ColumnInfo(name ="content")
    val content: String,
    @ColumnInfo(name = "date")
    val date: Long
)
