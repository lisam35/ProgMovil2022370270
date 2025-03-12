package com.example.appsonidos

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { UIPrincipal() }
    }
}

@Composable
fun BotonSonido(imageRes: Int, soundRes: Int, nombre: String) {
    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = nombre,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )
        Box(
            Modifier.size(100.dp).clickable {
                MediaPlayer.create(context, soundRes).start()
            },
            contentAlignment = Alignment.Center
        ) {
            Image(painterResource(id = imageRes), contentDescription = nombre)
        }
    }
}

@Composable
fun UIPrincipal(){
    val multimedios = listOf(
        Triple(R.drawable.anakin, R.raw.anakin_1, "Anakin 1"),
        Triple(R.drawable.anakin, R.raw.anakin_2, "Anakin 2"),
        Triple(R.drawable.anakin, R.raw.anakin_3, "Anakin 3"),
        Triple(R.drawable.anakin, R.raw.anakin_4, "Anakin 4"),
        Triple(R.drawable.anakin, R.raw.anakin_5, "Anakin 5"),
        Triple(R.drawable.chewie, R.raw.chewie, "Chewbacca"),
        Triple(R.drawable.han, R.raw.han, "Han Solo"),
        Triple(R.drawable.lando, R.raw.lando, "Lando"),
        Triple(R.drawable.luke, R.raw.luke, "Luke Skywalker"),
        Triple(R.drawable.saber, R.raw.saber, "Sable de luz"),
        Triple(R.drawable.vader, R.raw.vader, "Darth Vader"),
        Triple(R.drawable.yoda, R.raw.yoda, "Yoda"),
    )

    Column(Modifier.fillMaxSize().padding(8.dp).verticalScroll(rememberScrollState())) {
        for(i in multimedios.indices step 3){
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
                for(j  in 0 until 3 ){
                    if(i+j < multimedios.size){
                        BotonSonido(multimedios[i+j].first, multimedios[i+j].second, multimedios[i + j].third)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}