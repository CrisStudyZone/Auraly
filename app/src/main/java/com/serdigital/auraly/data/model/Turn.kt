package com.serdigital.auraly.data.model

data class Turn(
    val date: String = "", // formato ISO (yyyy-MM-dd)
    val hour: String = "", // formato 24h ("14:30")
    val clientId: String = "",
    val userId: String = "",
    val appointmentId: String? = null,
    val spaceId: String = "",
    val serviceId: String = ""
)
