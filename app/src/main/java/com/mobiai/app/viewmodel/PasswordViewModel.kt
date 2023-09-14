package com.mobiai.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobiai.app.db.notes.Note
import com.mobiai.app.db.password.Password
import com.mobiai.app.db.password.PasswordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PasswordViewModel : ViewModel() {
    private val passwordRepository = PasswordRepository()
    private val _password = MediatorLiveData<List<Password>>()
    val password: LiveData<List<Password>>
        get() = _password
    fun getPassword() {
        viewModelScope.launch(Dispatchers.Main) {
            val password = passwordRepository.getPassword()
            _password.addSource(password) {
                _password.value = it
            }
        }
    }
    fun createPassword(password: Password) {
        passwordRepository.createPassword(password)
    }
}