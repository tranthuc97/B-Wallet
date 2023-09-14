package com.mobiai.app.db.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionDao {

    @Query("SELECT * FROM question")
    fun getAllQuestion(): List<Question>

    @Insert
    suspend fun insert(question: Question)

    @Update
    suspend fun update(question: Question) {
    }

    @Query("SELECT id FROM question")
    fun getIdQuestion(): List<Long>

}