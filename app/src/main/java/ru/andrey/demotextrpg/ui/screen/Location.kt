package ru.andrey.demotextrpg.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.andrey.demotextrpg.ui.model.Mode
import ru.andrey.demotextrpg.ui.viewmodel.GameViewModel


@Composable
fun Location(
    viewModel: GameViewModel,
    navController: NavHostController
) {
    val model by viewModel.stateFlow.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = model.location.description,
            modifier = Modifier
                .padding(
                    bottom = 24.dp
                )
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Bottom),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
        for (direction in model.location.directions.filter { it.isVisible }) {

            Button(
                modifier = Modifier.padding(12.dp),
                onClick = {
                    viewModel.transfer(direction)
                    navController.navigate(Mode.MAIN.name)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = direction.name,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}