package com.example.rickandmortyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyproject.presentation.ui.NavGraph
import com.example.rickandmortyproject.ui.theme.RickAndMortyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyProjectTheme {
                Surface {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)                 }
            }
        }
    }
}
