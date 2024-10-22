package com.sample.coinmanual

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.coinmanual.api.AuthRequest
import com.sample.coinmanual.api.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var responseMessage = ""

    fun authenticate(apiKey: String, apiSecret: String, apiPassphrase: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.authenticate(AuthRequest(apiKey, apiSecret, apiPassphrase))
                responseMessage = if (response.code == "200000") {
                    "Authentication Successful: ${response.data}"
                } else {
                    "Authentication Failed: ${response.code}"
                }
            } catch (e: Exception) {
                responseMessage = "Error: ${e.localizedMessage}"
            }
        }
    }
}