package com.serdigital.auraly.data.model

data class Service(
    val id: String = "",
    val name: String = "",
    val duration: Int = 0, // en minutos
    val price: Double = 0.0,
    val input: String = "", // insumos requeridos
    val appointmentId: String? = null // puede ser null si no requiere equipo
)
