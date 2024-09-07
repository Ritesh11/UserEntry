package com.jio.userentry.data

import com.jio.userentry.data.model.ValuesEntered
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: ValuesEntered)
    suspend fun deleteUser(user: ValuesEntered)
    fun getUserList(): Flow<List<ValuesEntered>>
}