package com.mobiai.app.db.question


class QuestionRepository {
    private val dataSource = QuestionDataSource()
    suspend fun getListQuestion() = dataSource.getListQuestion()
    suspend fun getIdQuestion() = dataSource.getIdQuestion()
    fun addQuestion(question: Question) {
        dataSource.addQuestion(question)
    }
    fun updateQuestion(question: Question) {
        dataSource.updateQuestion(question)
    }
}