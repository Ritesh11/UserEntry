package com.jio.userentry.presenter.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jio.userentry.presenter.viewmodel.UserViewModel
import com.jio.userentry.presenter.viewmodel.UserViewModelFactory
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserEntryScreen(factory: UserViewModelFactory,
                    modifier: Modifier = Modifier,
                    viewModel: UserViewModel = viewModel(factory = factory)
) {

    var name by remember {
        mutableStateOf("")
    }
    var designation by remember {
        mutableStateOf("")
    }
    var salary by remember {
        mutableStateOf("")
    }

    var snackbarHostState = remember {
        SnackbarHostState()
    }

    var scope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }) {

        Column(
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = name, onValueChange = {
                    name = it
                },
                modifier = modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                label = {
                    Text(text = "Name")
                }
            )

            OutlinedTextField(
                value = designation, onValueChange = {
                    designation = it
                },
                modifier = modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                label = {
                    Text(text = "Position")
                }
            )

            OutlinedTextField(
                value = salary, onValueChange = {
                    salary = it
                },
                modifier = modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = {
                    Text(text = "Salary")
                }
            )


            Button(modifier = modifier.fillMaxWidth(),
                onClick = {
                    if (name.isNotEmpty() && designation.isNotEmpty() && salary.isNotEmpty()) {
                       // TODO save to DB
                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar("Please enter values")
                        }
                    }
                }) {

                Text(
                    text = "Save",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

    }
}