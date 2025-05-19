package com.serdigital.auraly.data.model

data class Appointment(
    val id: String = "",
    val status: Boolean = true, // true = operativo, false = en reparación
    val inputs: List<String> = emptyList(), // Insumos necesarios (IDs o nombres)
    val booking: Boolean = false // Está reservado o libre
)
