package com.example.cph_navi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cph_navi.ui.theme.CPHNAVITheme
// TODO: Add in the interactive buttons and whatnot, pretty simple
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SettingsScreen() {
    CPHNAVITheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = { Text(text = "Settings") }
                )
            },
            bottomBar = { BottomNavBar(selection = NavBarOptions.SETTINGS) }

        ) { innerPadding ->
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
            ) {
                Row {
                    Text(text = "Language", fontSize = 36.sp)
                }
                Row {
                    Text(text = "Speech Rate", fontSize = 36.sp)
                }
                Row {
                    Text(text = "Speech Pitch", fontSize = 36.sp)
                }
                Spacer(modifier = Modifier.weight(1F))
                Row {
                    Text(text = "Avoid stairs", fontSize = 20.sp)
                }
                Row (modifier = Modifier.padding(top = 4.dp)){
                    Text(text = "Predict favorable route", fontSize = 20.sp)
                }
                Row (modifier = Modifier.padding(top = 4.dp)){
                    Text(text = "Use camera to detect obstacles", fontSize = 20.sp)
                }
            }

        }
    }
}
