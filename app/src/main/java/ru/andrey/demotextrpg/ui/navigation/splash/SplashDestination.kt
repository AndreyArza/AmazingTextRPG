package ru.andrey.demotextrpg.ui.navigation.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.andrey.demotextrpg.ui.screen.Splash

class SplashDestination {
}

const val SPLASH_HOST = "SPLASH_HOST"

fun NavGraphBuilder.splashDestination(
    navController: NavController,
) {
    composable(
        route = SPLASH_HOST,
    ) {
        Splash(navController)
    }
}
