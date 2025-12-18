package ru.andrey.demotextrpg.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.andrey.demotextrpg.R
import ru.andrey.demotextrpg.ui.activity.LocalViewModelFactory
import ru.andrey.demotextrpg.ui.splash.viewmodel.SplashViewModel
import ru.andrey.demotextrpg.ui.theme.White

@Composable
fun Splash(
    navController: NavController,
) {
    val vm: SplashViewModel = viewModel(factory = LocalViewModelFactory.current)
    val state by vm.state.collectAsStateWithLifecycle()
    Column(modifier = Modifier.background(White)) {
        Image(
            painterResource(R.mipmap.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = state.toString(),
            modifier = Modifier
                .padding(
                    bottom = 24.dp
                )
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Bottom),
            textAlign = TextAlign.Center,
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge
        )
        LaunchedEffect(true) {
            //TODO navigation
        }
    }
}