package com.group3.cph_navi

sealed class Screen (val route: String){
    object HomeScreen : Screen("home_screen")
    object SettingsScreen : Screen("settings_screen")
    object VoiceAssistantScreen : Screen("voiceassistant_screen")
    object DestinationSelectScreen : Screen("destinationselect_screen")
    object MockNavigationScreen : Screen("mocknavigation_screen")
}