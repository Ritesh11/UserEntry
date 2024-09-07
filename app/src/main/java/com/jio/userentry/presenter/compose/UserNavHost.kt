package com.jio.userentry.presenter.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun UserNavHost(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = "user_list_screen") {
        composable(route = "user_list_screen") {
            UserListScreen(
                onNavigateToEntryScreen = {
                    navController.navigate("user_entry_screen")
                }
            )
        }

        composable(route = "user_entry_screen") {
            UserEntryScreen()
        }

    }

}