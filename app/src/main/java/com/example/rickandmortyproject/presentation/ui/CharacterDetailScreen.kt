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
fun CharacterDetailScreen(characterId: Int, viewModel: CharacterViewModel = viewModel()) {
    val character by viewModel.character.collectAsState()

    LaunchedEffect(key1 = characterId) {
        viewModel.fetchCharacterById(characterId)
    }

    character?.let { char ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = char.image,
                contentDescription = char.name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Name: ${char.name}", style = MaterialTheme.typography.headlineSmall)
            Text(text = "Status: ${char.status}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Species: ${char.species}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Type: ${char.type}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Gender: ${char.gender}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Origin: ${char.origin.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Location: ${char.location.name}", style = MaterialTheme.typography.bodyLarge)
        }
    } ?: run {
        Text(text = "Loading...", modifier = Modifier.padding(16.dp))
    }
}