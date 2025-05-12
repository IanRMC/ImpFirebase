package com.example.impfirebase

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

object NotificationViewModel : ViewModel() {
    private val _notificationState = mutableStateOf("No hay mensajes nuevos")
    val notificationState: State<String> get() = _notificationState

    private val _temporaryMessage = mutableStateOf("")
    val temporaryMessage: State<String> get() = _temporaryMessage

    fun showMessage(message: String) {
        _temporaryMessage.value = message
        // Limpiar después de 2 segundos
        Thread {
            Thread.sleep(2000)
            _temporaryMessage.value = ""
        }.start()
    }

    fun updateNotification(message: String) {
        _notificationState.value = message
    }
}
