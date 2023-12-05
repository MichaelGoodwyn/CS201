package com.group3.cph_navi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cph_navi.ui.theme.CPHNAVITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceAssistantScreen(navController: NavController) {
    CPHNAVITheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = { Text(text = "Voice Assistant") },
                    modifier = Modifier
                )
            },
            bottomBar = { BottomNavBar(navController) }
        ) { innerPadding ->
            @Suppress("UNUSED_VARIABLE") val junk = innerPadding
            Column {
                Image(
                    painter = painterResource(id = R.drawable.baseline_mic_24),
                    contentDescription = "Voice Assistant Active",
                    modifier = Modifier
                        .fillMaxHeight(0.75F)
                        .fillMaxWidth()
                        .background(Color.Transparent)
                )
                Text(
                    text = "Alternatively, select your destination through voice input",
                    fontSize = 32.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}