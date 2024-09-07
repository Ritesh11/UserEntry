package com.jio.userentry.presenter.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.jio.userentry.data.EntryEvent
import com.jio.userentry.presenter.adapter.UserCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen(
    onNavigateToEntryScreen: () -> Unit,
    modifier: Modifier = Modifier
) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(shape = CircleShape,
                    onClick = {
                        onNavigateToEntryScreen()
                    }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        ) {

            Column(
                modifier = modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                LazyColumn() {
                    item {
                        UserCard(EntryEvent.ValuesEntered("Ritesh", "Android Developer", "22,00,000"))
                    }
                }

            }

        }
    }


}