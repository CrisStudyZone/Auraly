package com.serdigital.auraly.ui.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.serdigital.auraly.R
import com.serdigital.auraly.ui.viewModel.AuthViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel = hiltViewModel(), modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val gso = remember {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
    }

    val googleSignInClient = remember {
        GoogleSignIn.getClient(context, gso)
    }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            viewModel.handleSignInResult(account)
        } catch (e: ApiException) {
            Log.e("LoginScreen", "Sign-in failed", e)
            viewModel.handleSignInResult(null) // Lanza error
        }
    }

    val authState by viewModel.authState.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Button(onClick = {
            launcher.launch(googleSignInClient.signInIntent)
        }) {
            Text("Iniciar sesión con Google")
        }

        when (authState) {
            is AuthViewModel.AuthState.Success -> {
                Text("Bienvenido ${(authState as AuthViewModel.AuthState.Success).userName}")
            }
            is AuthViewModel.AuthState.Error -> {
                Text("Error: ${(authState as AuthViewModel.AuthState.Error).message}")
            }
            AuthViewModel.AuthState.Idle -> Unit
        }
    }
}
