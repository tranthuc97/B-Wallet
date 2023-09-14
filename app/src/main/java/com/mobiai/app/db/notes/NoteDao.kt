package com.mobiai.app.db.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Note>
    @Insert
    suspend fun insert(note: Note)
    @Update
    suspend fun update(note: Note)
    @Query("SELECT id FROM notes")
    fun getIdNote(): List<Long>

}

