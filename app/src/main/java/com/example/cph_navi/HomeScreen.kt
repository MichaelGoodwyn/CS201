package com.example.cph_navi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cph_navi.ui.theme.CPHNAVITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationCard(
    navController: NavController,
    locationName: String,
    locationImage: Int,
    modifier: Modifier = Modifier
) {
    // val mMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.null_pointer_meme)
    // add mMediaPlayer.start() to the onClick call to make it play nullptr joke

    val painter = painterResource(id = locationImage)

    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            navController.navigate(Screen.DestinationSelectScreen.route + "/$locationName/$locationImage")
        },
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    CPHNAVITheme {
        Scaffold(
            topBar = {
                /*TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset((-8).dp),
                            value = text,
                            onValueChange = { text = it },
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
                )*/
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = text,
                    onValueChange = { text = it },
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
            bottomBar = {
                BottomNavBar(navController)
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .consumeWindowInsets(innerPadding)
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                item {
                    LocationCard(
                        navController,
                        "BSS",
                        R.drawable.bss
                    )
                }
                item {
                    LocationCard(
                        navController,
                        locationName = "Library",
                        R.drawable.library
                    )
                }
                item {
                    LocationCard(
                        navController,
                        locationName = "Theatre Arts",
                        R.drawable.theatre_arts
                    )
                }
                item {
                    LocationCard(
                        navController,
                        locationName = "Founder's Hall",
                        R.drawable.founders_hall
                    )
                }
            }
        }
    }
}