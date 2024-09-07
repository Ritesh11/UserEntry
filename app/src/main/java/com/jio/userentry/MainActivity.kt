package com.jio.userentry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jio.userentry.presenter.compose.UserNavHost
import com.jio.userentry.ui.theme.UserEntryTheme

class MainActivity : ComponentActivity() {
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

