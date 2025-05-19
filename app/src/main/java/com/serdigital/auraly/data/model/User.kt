package com.serdigital.auraly.data.model

data class User(
    val id: String = "", // UID de Firebase Auth
    val name: String = "",
    val email: String = "", // Obligatorio para login
    val phone: String = "",
    val role: List<String> = emptyList() // Roles según habilidades (puede ser más de uno)
)
