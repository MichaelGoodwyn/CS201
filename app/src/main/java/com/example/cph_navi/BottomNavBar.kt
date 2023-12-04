@file:Suppress("RedundantIf")

package com.example.cph_navi

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState



@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.HomeScreen.route } == true,//if (selection == NavBarOptions.HOME) true else false,
            onClick = {
                navController.navigate(Screen.HomeScreen.route) {
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.VoiceAssistantScreen.route } == true,
            onClick = {
                navController.navigate(Screen.VoiceAssistantScreen.route) {
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_mic_24),
                    contentDescription = "Voice Assistant"
                )
            },
            label = { Text(text = "Voice Assistant") }
        )
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.SettingsScreen.route } == true,
            onClick = {
                navController.navigate(Screen.SettingsScreen.route) {
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            },
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