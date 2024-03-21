package com.example.witcheriv.ui.navigation

import androidx.annotation.StringRes
import com.example.witcheriv.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Splash : Screen("SPLASH", R.string.splash)
    object Game : Screen("GAME", R.string.game)
}