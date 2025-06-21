package com.example.decideporti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.decideporti.ui.theme.DecidePorTiTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecidePorTiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val message = remember { mutableStateOf("") }
    val text = remember { mutableStateOf("") }


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = "Estás na Dúvida?",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Faz uma pergunta e irei ajudar-te a decidir ;)",
            style = MaterialTheme.typography.bodyMedium,
        )
        TextField(
            value = text.value,
            onValueChange = { newText -> text.value = newText },
            label = { Text("Faz a tua pergunta!") },


            )
        Text(
            text = message.value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
        Button(
            onClick = {
                val results = listOf("Com certeza!", "Não!", "Talvez!", "Sim!", "Nunca na vida!")
                val index = Random.Default.nextInt(results.size)
                message.value = results[index]
            }
        ) {
            Text("Perguntar")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DecidePorTiTheme {
        App()
    }
}
