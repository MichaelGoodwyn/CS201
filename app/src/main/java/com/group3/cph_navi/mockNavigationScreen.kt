package com.group3.cph_navi


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockNaviation(navController: NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Navigating",fontSize = 36.sp)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,)
            )
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) {innerPadding->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.weight(0.50F))
            Text(text = "Walk 20 steps forward", fontSize = 36.sp)
            Spacer(modifier = Modifier.weight(0.25F))
            Button(onClick = { navController.popBackStack() },
                Modifier
                    .height(58.dp)
                    .fillMaxWidth(0.6F)) {
                Text(text = "Select Alternate Route")
            }
            Button(onClick = { navController.popBackStack(Screen.HomeScreen.route, inclusive = false) },
                modifier = Modifier
                .padding(bottom = 16.dp)
                .height(58.dp)
                .fillMaxWidth(0.6F)
            ) {
                Text(text = "Exit Navigation")
            }
        }

    }
}

@Preview
@Composable
fun PreviewMockNavigationScreen(){
    MockNaviation(navController = rememberNavController())
}