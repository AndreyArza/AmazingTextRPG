package ru.andrey.demotextrpg.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.andrey.demotextrpg.app.App
import ru.andrey.demotextrpg.network.source.interfaces.NetworkSource
import ru.andrey.demotextrpg.ui.theme.WitcherIVTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var source: NetworkSource

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)

        lifecycleScope.launch {
            source.getActions("", 1).collect { res ->
                val a = res.getOrNull()!!
                Log.d(
                    "AAAAAAAAAAAAAAAAAAAAAAAA",
                    "${a.values.size} ${a.loaded} ${a.total}"
                )
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            WitcherIVTheme {
                Text("))")
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = Screen.Splash.route) {
//                        composable(Screen.Splash.route) {
//                            Splash(
//                                createExternalRouter { screen, params ->
//                                    navController.navigate(screen, params)
//                                },
//                                lifecycleScope
//                            )
//                        }
//                        composable(Screen.Game.route) {
//                            Game()
//                        }
//                    }
//                }
            }
        }
    }
}

