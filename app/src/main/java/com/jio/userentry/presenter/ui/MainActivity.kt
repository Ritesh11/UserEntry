package com.jio.userentry.presenter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.jio.userentry.presenter.compose.UserNavHost
import com.jio.userentry.presenter.viewmodel.UserViewModelFactory
import com.jio.userentry.ui.theme.UserEntryTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserEntryTheme {
                UserNavHost()
            }
        }
    }
}

