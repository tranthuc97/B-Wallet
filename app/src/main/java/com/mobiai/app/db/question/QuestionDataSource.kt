package com.mobiai.app.db.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobiai.app.db.AppDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class QuestionDataSource: CoroutineScope {
    suspend fun getListQuestion(): LiveData<List<Question>> {
        val listQuestion = withContext(Dispatchers.IO) {
            AppDataBase.getDatabaseClient().questionDao().getAllQuestion()
        }
        val result = MutableLiveData<List<Question>>()
        result.value = listQuestion
        return result
    }

    suspend fun getIdQuestion(): LiveData<List<Long>> {
        val listQuestion = withContext(Dispatchers.IO) {
            AppDataBase.getDatabaseClient().questionDao().getIdQuestion()
        }
        val result = MutableLiveData<List<Long>>()
        result.value = listQuestion
        return result
    }fun addQuestion(question: Question) {
        launch(Dispatchers.IO) {
            AppDataBase.getDatabaseClient().questionDao().insert(question)
        }
    }

    fun updateQuestion(question: Question){
        launch(Dispatchers.IO){
            AppDataBase.getDatabaseClient().questionDao().update(question)
        }
    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}
