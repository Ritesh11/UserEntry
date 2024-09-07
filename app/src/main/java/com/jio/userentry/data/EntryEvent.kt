package com.jio.userentry.data

sealed class EntryEvent() {
    data class ValuesEntered(
        val name: String,
        val position: String,
        val salary: String
    ) : EntryEvent()

    object saveBtnClicked : EntryEvent()
}
