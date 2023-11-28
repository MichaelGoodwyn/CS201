@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cph_navi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cph_navi.ui.theme.CPHNAVITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CPHNAVITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LocationCardsPreview()
                }
            }
        }
    }
}

// TODO: Refactor the lousy setContent block above and implement proper navigation handling.
// TODO: Create HomeScreen Composable based off of the current setup of lazy columns and static sections


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationCard(locationName: String, painter: Painter, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
        shape = RectangleShape
    ) {
        Box(
            modifier = Modifier
                .height(175.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = locationName,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = locationName,
                textAlign = TextAlign.Center,
                fontSize = 52.sp,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LocationCardsPreview() {
    CPHNAVITheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(-8.dp),
                            value = "",
                            onValueChange = {},
                            placeholder = { Text(text = "Enter Destination") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_search),
                                    contentDescription = null
                                )
                            },
                            shape = RectangleShape
                        )
                    },
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier
                ) {
                    NavigationBarItem(
                        selected = true,
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
                        selected = false,
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
                        selected = false,
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
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .consumeWindowInsets(innerPadding)
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                item { LocationCard("BSS", painterResource(id = R.drawable.bss)) }
                item {
                    LocationCard(
                        locationName = "Library",
                        painter = painterResource(id = R.drawable.library)
                    )
                }
                item {
                    LocationCard(
                        locationName = "Theatre Arts",
                        painter = painterResource(id = R.drawable.theatre_arts)
                    )
                }
                item {
                    LocationCard(
                        locationName = "Founder's Hall",
                        painter = painterResource(id = R.drawable.founders_hall)
                    )
                }
            }
        }
    }
}