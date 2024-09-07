package com.jio.userentry.data

import com.jio.userentry.data.db.UserDao
import com.jio.userentry.data.model.EntryEvent
import com.jio.userentry.data.model.ValuesEntered
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override suspend fun insertUser(user: ValuesEntered) {
        userDao.insertUser(user)
    }

    override suspend fun deleteUser(user: ValuesEntered) {
        userDao.deleteUser(user)
    }

    override fun getUserList(): Flow<List<ValuesEntered>> {
        return userDao.getUserList()
    }
}