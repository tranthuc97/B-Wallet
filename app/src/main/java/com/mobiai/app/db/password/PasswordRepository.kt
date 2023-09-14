package com.mobiai.app.db.password

import com.mobiai.app.db.notes.Note

class PasswordRepository {
    private val dataSource = PasswordDatasource()
    suspend fun getPassword() = dataSource.getPassword()
    fun createPassword(password: Password) {
        dataSource.createPassword(password)
    }
}