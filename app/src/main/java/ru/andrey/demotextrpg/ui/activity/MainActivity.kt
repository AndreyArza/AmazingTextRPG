package ru.andrey.demotextrpg.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ru.andrey.demotextrpg.app.App
import ru.andrey.demotextrpg.network.source.interfaces.NetworkSource
import ru.andrey.demotextrpg.ui.activity.di.DaggerViewModelFactory
import ru.andrey.demotextrpg.ui.navigation.NavGraph
import ru.andrey.demotextrpg.ui.theme.WitcherIVTheme
import javax.inject.Inject

val LocalViewModelFactory = staticCompositionLocalOf<ViewModelProvider.Factory> {
    throw IllegalStateException("No factory provided")
}
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var source: NetworkSource

    @Inject
    lateinit var commonFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)

        lifecycleScope.launch {
            val a = source.getDirections("", 2)
            a.collect { res ->
                val a = res.getOrNull()!!
                Log.d(
                    "AAAAAAAAAAAAAAAAAAAAAAAA",
                    "${a.values.size} ${a.loaded} ${a.total}"
                )
            }
            Log.d(
                "AAAAAAAAAAAAAAAAAAAAAAAA",
                "FINISH"
            )
        }
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalViewModelFactory provides commonFactory) {
                WitcherIVTheme {
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}

