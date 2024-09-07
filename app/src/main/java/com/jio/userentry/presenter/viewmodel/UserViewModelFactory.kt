package com.jio.userentry.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jio.userentry.data.UserRepository
import javax.inject.Inject

class UserViewModelFactory
@Inject constructor(private val userRepo: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = UserViewModel(userRepo) as T
}