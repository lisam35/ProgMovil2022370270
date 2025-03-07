package com.example.holatoastsuma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { UIPrincipal() }
    }
}

@Composable
fun UIPrincipal() {
    var cadTxtOp1 by remember { mutableStateOf("") }
    var cadTxtOp2 by remember { mutableStateOf("") }
    var cadTxtRes by remember { mutableStateOf("") }

    fun btnLimpiar_click() {
        cadTxtOp1 = ""
        cadTxtOp2 = ""
        cadTxtRes = ""
    }

    fun btnSumar_click() {
        val op1 = cadTxtOp1.toIntOrNull() ?: 0
        val op2 = cadTxtOp2.toIntOrNull() ?: 0
        cadTxtRes = (op1 + op2).toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("Op1", Modifier.weight(1f))
            Text("Op2", Modifier.weight(1f))
            Text("Res", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre filas

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextField(
                value = cadTxtOp1,
                onValueChange = { cadTxtOp1 = it },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            TextField(
                value = cadTxtOp2,
                onValueChange = { cadTxtOp2 = it },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            TextField(
                value = cadTxtRes,
                onValueChange = { },
                readOnly = true,  // Evita que se edite manualmente
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado antes de los botones

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { btnLimpiar_click() },
                modifier = Modifier.weight(1.5f)
            ) {
                Text("Limpiar")
            }
            Button(
                onClick = { btnSumar_click() },
                modifier = Modifier.weight(1.5f)
            ) {
                Text("Sumar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}
