package com.jio.userentry.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class EntryEvent() {

    @Entity(tableName = "user")
    data class ValuesEntered(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo("user_id")
        val id: Int,
        @ColumnInfo("user_name")
        val name: String,
        @ColumnInfo("user_position")
        val position: String,
        @ColumnInfo("user_salary")
        val salary: String
    ) : EntryEvent()

    object saveBtnClicked : EntryEvent()
}
