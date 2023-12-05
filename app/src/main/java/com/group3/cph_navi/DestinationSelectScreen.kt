package com.group3.cph_navi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationSelectScreen(
    navController: NavController,
    destinationName: String?,
    destinationImage: Int?
) {
    Scaffold(
        topBar = {
            val painter = destinationImage?.let { painterResource(id = it) }
            Box(modifier = Modifier.fillMaxWidth()) {
                if (painter != null) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                CenterAlignedTopAppBar(
                    title = {
                        if (destinationName != null) {
                            Text(
                                text = destinationName,
                                color = Color.White,
                                fontSize = 52.sp,
                                maxLines = 1
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent)
                )
            }
        },
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        var roomNumber by remember {
            mutableStateOf("")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.85F)
                    .height(58.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Nearest Water Fountain")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.85F)
                    .height(58.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Nearest Bathroom")
            }
            Row(
                modifier = Modifier
                    .height(58.dp)
                    .fillMaxWidth(0.85f)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = ButtonDefaults.filledTonalShape
                    )
            ) {
                Text(
                    text = "Enter Room Number:",
                    textAlign = TextAlign.End,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .weight(0.70F)
                )
                OutlinedTextField(
                    modifier = Modifier.weight(0.20F, fill = false),
                    value = roomNumber,
                    onValueChange = {
                        if (it.isDigitsOnly() && it.length < 4) {
                            roomNumber = it
                        }
                    },
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.onPrimary),
                    maxLines = 1,
                    placeholder = { Text(text = "###", color = MaterialTheme.colorScheme.onPrimary)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.weight(0.09F))
            }
            Button(onClick = { navController.navigate(Screen.MockNavigationScreen.route) },
                modifier = Modifier
                    .fillMaxWidth(.6F)
                    .height(58.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
                ) {
                Text(text = "Set Destination", color = MaterialTheme.colorScheme.onTertiary)
            }

        }
    }
}

@Preview
@Composable
fun DestinationSelectScreenPreview() {
    DestinationSelectScreen(
        navController = rememberNavController(),
        destinationName = "BSS",
        destinationImage = R.drawable.bss
    )
}