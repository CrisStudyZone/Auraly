package com.serdigital.auraly.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState = _authState.asStateFlow()

    fun handleSignInResult(account: GoogleSignInAccount?) {
        viewModelScope.launch {
            try {
                val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
                auth.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthState.Success(auth.currentUser?.displayName ?: "Usuario")
                        Log.d("Auth", "Login OK: ${auth.currentUser?.email}")
                    } else {
                        _authState.value = AuthState.Error("Error al autenticar: ${task.exception?.message}")
                        Log.e("Auth", "Firebase signInWithCredential error", task.exception)
                    }
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error("Error al obtener credencial: ${e.message}")
                Log.e("Auth", "Error de autenticación", e)
            }
        }
    }

    fun logout() {
        auth.signOut()
        _authState.value = AuthState.Idle
    }

    sealed class AuthState {
        object Idle : AuthState()
        data class Success(val userName: String) : AuthState()
        data class Error(val message: String) : AuthState()
    }
}
