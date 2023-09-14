package com.mobiai.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiai.app.db.question.Question
import com.mobiai.app.db.question.QuestionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel : ViewModel() {
    private val questionRepository = QuestionRepository()
    private val _listQuestion = MediatorLiveData<List<Question>>()
    val listQuestion: LiveData<List<Question>>
        get() = _listQuestion
    fun getListQuestion() {
        viewModelScope.launch(Dispatchers.Main) {
            val question = questionRepository.getListQuestion()
            _listQuestion.addSource(question) {
                _listQuestion.value = it
            }
        }
    }
    private val _listId = MediatorLiveData<List<Long>>()
    val listId: MediatorLiveData<List<Long>>
        get() = _listId
    fun getIdQuestion() {
        viewModelScope.launch(Dispatchers.Main) {
            val id = questionRepository.getIdQuestion()
            _listId.addSource(id) {
                _listId.value = it
            }
        }
    }
    fun addQuestion(question: Question) {
        questionRepository.addQuestion(question)
    }
    fun updateQuestion(question: Question) {
        questionRepository.updateQuestion(question)
    }

}