package com.jio.userentry.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jio.userentry.data.model.EntryEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: EntryEvent.ValuesEntered)

    @Delete
    suspend fun deleteUser(user: EntryEvent.ValuesEntered)

    @Query("SELECT * FROM user")
    fun getUserList(): Flow<List<EntryEvent.ValuesEntered>>

}