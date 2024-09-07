package com.jio.userentry.data

import com.jio.userentry.data.db.UserDao
import com.jio.userentry.data.model.EntryEvent
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override suspend fun insertUser(user: EntryEvent.ValuesEntered) {
        userDao.insertUser(user)
    }

    override suspend fun deleteUser(user: EntryEvent.ValuesEntered) {
        userDao.deleteUser(user)
    }

    override fun getUserList(): Flow<List<EntryEvent.ValuesEntered>> {
        return userDao.getUserList()
    }
}