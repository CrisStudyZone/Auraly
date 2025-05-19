package com.serdigital.auraly.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.serdigital.auraly.data.datasource.remote.FirebaseService
import com.serdigital.auraly.data.model.Client
import com.serdigital.auraly.data.repository.ClientRepositoryImpl
import com.serdigital.auraly.domain.usecase.SaveClientUseCase

@Composable
fun ClientScreen(modifier: Modifier) {
    val firebaseService = FirebaseService()
    val repository = ClientRepositoryImpl(firebaseService)
    val saveClientUseCase = SaveClientUseCase(repository)

    val client = Client(
        id = "client1",
        name = "Lucía Fernández",
        phone = "1122334455",
        email = "lucia@example.com",
        notes = "Alergia al látex"
    )
    // ✅ Mostramos algo visible en pantalla
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Cliente guardado...",
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}
