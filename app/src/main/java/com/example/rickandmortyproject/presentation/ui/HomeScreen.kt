package com.example.rickandmortyproject.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Page d'accueil", style = androidx.compose.material3.MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("character_detail/1")
            }
        ) {
            Text(text = "Voir les détails de Rick Sanchez")
        }
        Button(
            onClick = {
                navController.navigate("character_list")
            }
        ) {
            Text(text = "Voir tous les personnages")
        }
    }
}
