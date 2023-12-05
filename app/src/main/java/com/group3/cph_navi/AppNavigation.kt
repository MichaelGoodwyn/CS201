package com.group3.cph_navi

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation(){
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.VoiceAssistantScreen.route){
            VoiceAssistantScreen(navController)
        }
        composable(route = Screen.SettingsScreen.route){
            SettingsScreen(navController)
        }
        composable(
            route = Screen.DestinationSelectScreen.route + "/{destinationName}/{destinationImage}",
            arguments = listOf(
                navArgument("destinationName"){
                    type = NavType.StringType
                },
                navArgument("destinationImage"){
                    type = NavType.IntType
                }
            )
        ){entry->
            DestinationSelectScreen(
                navController = navController,
                destinationName = entry.arguments?.getString("destinationName"),
                destinationImage = entry.arguments?.getInt("destinationImage"))
        }
        composable(
            route = Screen.MockNavigationScreen.route
        ){
            MockNaviation(navController = navController)
        }
    }
}