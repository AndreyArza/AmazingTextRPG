package ru.andrey.demotextrpg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import ru.andrey.demotextrpg.ui.navigation.splash.SPLASH_HOST
import ru.andrey.demotextrpg.ui.navigation.splash.splashNavHost


private const val MAIN_NAV_HOST = "mainNavHost"
@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MAIN_NAV_HOST,
        modifier = modifier,
    ) {
        navigation(
            startDestination = SPLASH_HOST, route = MAIN_NAV_HOST
        ) {
            splashNavHost()
        }
    }
}