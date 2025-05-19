package com.serdigital.auraly.data.datasource.remote

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.serdigital.auraly.data.model.Client

class FirebaseService {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun saveClient(client: Client, onResult: (Boolean) -> Unit) {
        val clientRef = database.child("clients").child(client.id)
        clientRef.setValue(client)
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }
}
