package com.serdigital.auraly.domain.repository

import com.serdigital.auraly.data.model.Client

interface ClientRepository {
    fun saveClient(client: Client, onResult: (Boolean) -> Unit)
}
