package com.jio.userentry.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class EntryEvent() {
    object saveBtnClicked : EntryEvent()
}
