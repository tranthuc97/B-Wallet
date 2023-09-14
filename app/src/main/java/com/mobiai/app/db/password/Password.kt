package com.mobiai.app.db.password

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwords")
data class Password(
    @PrimaryKey
    @ColumnInfo(name = "password")
    val password: String
)