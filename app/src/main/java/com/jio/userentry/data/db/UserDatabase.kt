package com.jio.userentry.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jio.userentry.data.model.EntryEvent
import com.jio.userentry.data.model.ValuesEntered

@Database(
    entities = [ValuesEntered::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}