package com.jio.userentry.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jio.userentry.data.UserRepository
import com.jio.userentry.data.model.ValuesEntered
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    var users = userRepository.getUserList()

    fun insertUser(user: ValuesEntered) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }
}