package com.mobiai.app.db.password

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PasswordDao {
    @Query("SELECT * FROM passwords")
    fun getPassword(): List<Password>
    @Insert
    suspend fun insert(password: Password)
}