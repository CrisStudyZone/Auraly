package com.serdigital.auraly.data.model

data class GroupService(
    val id: String = "",
    val name: String = "",
    val duration: Int = 0, // en minutos
    val price: Double = 0.0,
    val input: String = "", // insumos requeridos
    val appointmentId: String? = null,
    val clientIds: List<String> = emptyList(),
    val maxParticipants: Int = 0
)
