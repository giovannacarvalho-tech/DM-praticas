package com.example.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var userName by rememberSaveable() { mutableStateOf("")}
    var repeatPassword by rememberSaveable() {mutableStateOf("") }
    val activity = LocalActivity.current as Activity

    Column(
        modifier = modifier.padding(24.dp).fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {

        Text(
            text = "Criar Conta",
            fontSize = 24.sp
        )

        Spacer(modifier = modifier.size(8.dp))

        OutlinedTextField(
            value = userName,
            label = { Text(text = "Nome") },
            modifier = modifier,
            onValueChange = { userName = it }
        )


        Spacer(modifier = modifier.size(8.dp))

        OutlinedTextField(
            value = email,
            label = {Text("E-mail")},
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = modifier.size(8.dp))

        OutlinedTextField(
            value = password,
            label = { Text(text = "Senha") },
            modifier = modifier,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )


        Spacer(modifier = modifier.size(8.dp))

        OutlinedTextField(
            value = repeatPassword,
            label = { Text(text = "Repita a senha") },
            modifier = modifier,
            onValueChange = { repeatPassword = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.size(8.dp))

        Button(
            onClick = {

            },
            enabled = userName.isNotEmpty() &&
                    email.isNotEmpty() &&
                    password.isNotEmpty() &&
                    repeatPassword.isNotEmpty()
        ) {
            Text("Registrar")
        }

        Button( onClick = {
                userName = ""
                email = ""
                password = ""
                repeatPassword = ""
            }
        ) {
                Text("Limpar")
            }
    }
}