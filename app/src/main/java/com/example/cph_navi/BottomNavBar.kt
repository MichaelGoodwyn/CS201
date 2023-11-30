@file:Suppress("RedundantIf")

package com.example.cph_navi

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource


enum class NavBarOptions {
    HOME,
    VOICEASSISTANT,
    SETTINGS
}


@Composable
fun BottomNavBar(selection: NavBarOptions){
    NavigationBar(
        modifier = Modifier
    ) {
        NavigationBarItem(
            selected = if (selection == NavBarOptions.HOME) true else false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = if (selection == NavBarOptions.VOICEASSISTANT) true else false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_mic_24),
                    contentDescription = "Voice Assistant"
                )
            },
            label = { Text(text = "Voice Assistant") }
        )
        NavigationBarItem(
            selected = if (selection == NavBarOptions.SETTINGS) true else false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "Settings"
                )
            },
            label = { Text(text = "Settings") }
        )
    }
}