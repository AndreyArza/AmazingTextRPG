package com.example.witcheriv.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.witcheriv.R
import com.example.witcheriv.ui.navigation.Router
import com.example.witcheriv.ui.navigation.Screen
import com.example.witcheriv.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun Splash(
    router: Router,
    scope: CoroutineScope
) {
    Column(modifier = Modifier.background(White) ){

        Image(
            painterResource(R.mipmap.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Witcher IV",
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
        LaunchedEffect(router) {
            scope.launch(Dispatchers.Default) {
                delay(3000)
                launch(Dispatchers.Main) {
                    router.routeTo(Screen.Game.route)
                }
            }
        }
    }
}