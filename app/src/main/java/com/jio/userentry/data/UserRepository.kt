package com.jio.userentry.data

import com.jio.userentry.data.model.EntryEvent
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: EntryEvent.ValuesEntered)
    suspend fun deleteUser(user: EntryEvent.ValuesEntered)
    fun getUserList(): Flow<List<EntryEvent.ValuesEntered>>
}