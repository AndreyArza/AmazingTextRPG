package ru.andrey.demotextrpg.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.andrey.demotextrpg.ui.navigation.Screen
import ru.andrey.demotextrpg.ui.navigation.createExternalRouter
import ru.andrey.demotextrpg.ui.navigation.navigate
import ru.andrey.demotextrpg.ui.screen.Game
import ru.andrey.demotextrpg.ui.screen.Splash
import ru.andrey.demotextrpg.ui.theme.WitcherIVTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WitcherIVTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Splash.route) {
                        composable(Screen.Splash.route) {
                            Splash(
                                createExternalRouter { screen, params ->
                                    navController.navigate(screen, params)
                                },
                                lifecycleScope
                            )
                        }
                        composable(Screen.Game.route) {
                            Game()
                        }
                    }
                }
            }
        }
    }
}

