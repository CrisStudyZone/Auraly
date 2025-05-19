package com.serdigital.auraly.domain.usecase

import com.serdigital.auraly.data.model.Client
import com.serdigital.auraly.domain.repository.ClientRepository

class SaveClientUseCase(
    private val repository: ClientRepository
) {
    operator fun invoke(client: Client, onResult: (Boolean) -> Unit) {
        repository.saveClient(client, onResult)
    }
}
