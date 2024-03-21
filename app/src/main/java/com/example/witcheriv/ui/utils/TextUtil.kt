package com.example.witcheriv.ui.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.witcheriv.R
import com.example.witcheriv.ui.model.Mode


@Composable
fun text(mode: Mode) {
    when (mode) {
        Mode.MAIN -> Text(stringResource(id = R.string.main))
        Mode.LOCATION -> Text(stringResource(id = R.string.transfer))
        Mode.INFO -> Text(stringResource(id = R.string.info))
    }
}

