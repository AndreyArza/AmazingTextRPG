package ru.andrey.demotextrpg.ui.navigation.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

fun NavGraphBuilder.splashNavHost() {
    composable(SPLASH_HOST) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = SPLASH_HOST) {
            splashDestination(navController)
        }
    }
}