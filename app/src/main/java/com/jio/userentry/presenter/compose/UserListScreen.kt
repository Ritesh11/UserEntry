package com.jio.userentry.presenter.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jio.userentry.data.model.EntryEvent
import com.jio.userentry.presenter.adapter.UserCard
import com.jio.userentry.presenter.viewmodel.UserViewModel
import com.jio.userentry.presenter.viewmodel.UserViewModelFactory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserListScreen(
    factory: UserViewModelFactory,
    onNavigateToEntryScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(factory = factory)
) {

    val userList = viewModel.users.collectAsState(initial = emptyList())

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

                LazyColumn(
                    modifier = modifier.padding(top = 20.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items = userList.value,
                        key = { item -> item.id }
                    ) { item ->
                        UserCard(valuesEntered = item)
                    }
                }

            }

        }
    }


}