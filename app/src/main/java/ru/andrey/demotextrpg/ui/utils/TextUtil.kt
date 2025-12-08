package ru.andrey.demotextrpg.ui.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.andrey.demotextrpg.R
import ru.andrey.demotextrpg.ui.model.Mode


@Composable
fun Text(mode: Mode) {
    when (mode) {
        Mode.MAIN -> Text(stringResource(id = R.string.main))
        Mode.LOCATION -> Text(stringResource(id = R.string.transfer))
        Mode.INFO -> Text(stringResource(id = R.string.info))
    }
}

