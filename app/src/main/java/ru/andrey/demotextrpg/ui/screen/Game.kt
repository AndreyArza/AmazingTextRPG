package ru.andrey.demotextrpg.ui.screen

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.andrey.demotextrpg.ui.model.Mode
import ru.andrey.demotextrpg.ui.utils.Text
import ru.andrey.demotextrpg.ui.viewmodel.GameViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalAnimationApi
@Composable
fun Game(
    viewModel: GameViewModel = viewModel(),
) {
    val navController = rememberNavController()
    val bottomItems = Mode.values()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                bottomItems.forEach { mode ->
                    NavigationBarItem(
                        selected = true,
                        onClick = {
                            navController.navigate(mode.name) {
                                popUpTo = navController.graph.startDestinationId
                                launchSingleTop = true
                            }
                        },
                        label = { Text(mode) },
                        icon = {

                        })
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Mode.MAIN.name) {
            composable(Mode.MAIN.name) { MainGame(viewModel) }
            composable(Mode.LOCATION.name) { Location(viewModel, navController) }
            composable(Mode.INFO.name) { Info(viewModel) }
        }
    }
}
