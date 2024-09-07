package com.jio.userentry.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jio.userentry.data.model.ValuesEntered
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: ValuesEntered)

    @Delete
    suspend fun deleteUser(user: ValuesEntered)

    @Query("SELECT * FROM user")
    fun getUserList(): Flow<List<ValuesEntered>>

}