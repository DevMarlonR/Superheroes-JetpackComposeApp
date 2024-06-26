package com.example.superherois

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.superherois.model.HeroesRepository
import com.example.superherois.ui.theme.SuperheroisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroisTheme {
                HeroApp(
                    heroes = HeroesRepository.heroes,
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                )
                HeroApp(
                    heroes = HeroesRepository.heroes,
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                )
            }
        }
    }
}
