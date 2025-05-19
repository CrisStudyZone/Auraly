package com.serdigital.auraly.data.model

data class Account(
    val services: List<String> = emptyList(), // IDs de servicios contratados
    val payments: List<Payment> = emptyList(),
    val isUpToDate: Boolean = true
)
