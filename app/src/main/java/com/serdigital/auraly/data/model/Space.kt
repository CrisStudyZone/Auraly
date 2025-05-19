package com.serdigital.auraly.data.model

data class Space(
    val id: String = "",
    val name: String = "", // Ej: "Consultorio 1", "Zona de Pilates"
    val appointmentId: String? = null, // Si requiere un equipo
    val type: String = ""
)
