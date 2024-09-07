package com.jio.userentry.presenter.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jio.userentry.presenter.viewmodel.UserViewModel
import com.jio.userentry.presenter.viewmodel.UserViewModelFactory

@Composable
fun UserNavHost(factory: UserViewModelFactory,
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = "user_list_screen") {
        composable(route = "user_list_screen") {
            UserListScreen(factory,
                onNavigateToEntryScreen = {
                    navController.navigate("user_entry_screen")
                }
            )
        }

        composable(route = "user_entry_screen") {
            UserEntryScreen(factory)
        }

    }

}