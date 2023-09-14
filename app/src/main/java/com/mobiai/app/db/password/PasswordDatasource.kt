package com.mobiai.app.db.password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobiai.app.db.AppDataBase
import com.mobiai.app.db.notes.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class PasswordDatasource : CoroutineScope {
    fun createPassword(password: Password) {
        launch(Dispatchers.IO) {
            AppDataBase.getDatabaseClient().passWordDao().insert(password)
        }
    }
    suspend fun getPassword(): LiveData<List<Password>> {
        val password = withContext(Dispatchers.IO) {
            AppDataBase.getDatabaseClient().passWordDao().getPassword()
        }
        val result = MutableLiveData<List<Password>>()
        result.value = password
        return result
    }





    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}