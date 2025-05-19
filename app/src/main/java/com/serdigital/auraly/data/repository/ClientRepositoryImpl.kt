package com.serdigital.auraly.data.repository
import com.serdigital.auraly.data.datasource.remote.FirebaseService
import com.serdigital.auraly.data.model.Client
import com.serdigital.auraly.domain.repository.ClientRepository

class ClientRepositoryImpl(
    private val firebaseService: FirebaseService
) : ClientRepository {
    override fun saveClient(client: Client, onResult: (Boolean) -> Unit) {
        firebaseService.saveClient(client, onResult)
    }
}
