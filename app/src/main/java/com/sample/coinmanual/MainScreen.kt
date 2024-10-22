package com.sample.coinmanual

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen() {
    var apiKey by remember { mutableStateOf("") }
    var apiSecret by remember { mutableStateOf("") }
    var apiPassphrase by remember { mutableStateOf("") }
    var responseMessage by remember { mutableStateOf("") }

    val viewModel: MainViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = apiKey,
            onValueChange = { apiKey = it },
            label = { Text("API Key") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = apiSecret,
            onValueChange = { apiSecret = it },
            label = { Text("API Secret") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = apiPassphrase,
            onValueChange = { apiPassphrase = it },
            label = { Text("API Passphrase") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.authenticate(apiKey, apiSecret, apiPassphrase)
            responseMessage = viewModel.responseMessage
        }) {
            Text("Authorize")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(responseMessage)
    }
}