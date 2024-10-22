package com.example.rickandmortyproject.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.rickandmortyproject.presentation.viewmodel.CharacterViewModel

@Composable
fun CharacterDetailScreen(viewModel: CharacterViewModel = viewModel(), characterId: Int) {

    val character by viewModel.character.collectAsState()

    LaunchedEffect(key1 = characterId) {
        println("Lancement de fetchCharacterById avec l'ID : $characterId")
        viewModel.fetchCharacterById(characterId)
    }

    character?.let { char ->
        println("Affichage des détails du personnage : ${char.name}")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Name: ${char.name}", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Status: ${char.status}")
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = char.image,
                contentDescription = char.name,
                modifier = Modifier.size(200.dp)
            )
        }
    } ?: run {
        Text(text = "Loading...", modifier = Modifier.padding(16.dp))
    }
}
