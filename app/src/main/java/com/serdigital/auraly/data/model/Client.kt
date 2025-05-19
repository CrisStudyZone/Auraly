package com.serdigital.auraly.data.model

data class Client(
    val id: String = "",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val account: Account = Account(),
    val notes: String = "" // Aqui estaran almacenados los datos medicos o detalles necesarios del cliente
)
