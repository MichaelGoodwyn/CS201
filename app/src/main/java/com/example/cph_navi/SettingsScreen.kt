package com.example.cph_navi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cph_navi.ui.theme.CPHNAVITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
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
            bottomBar = { BottomNavBar(navController) }

        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.98F)
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Language",
                        fontSize = 36.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .weight(0.50F)
                    )
                    val options = listOf("English", "Español", "français", "日本語", "中文")
                    var expanded by remember { mutableStateOf(false) }
                    var selectedOptionText by remember { mutableStateOf(options[0]) }
                    // We want to react on tap/press on TextField to show menu
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                        modifier = Modifier.weight(0.25F)
                    ) {
                        TextField(
                            // The `menuAnchor` modifier must be passed to the text field for correctness.
                            modifier = Modifier.menuAnchor(),
                            readOnly = true,
                            value = selectedOptionText,
                            onValueChange = {},
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            options.forEach { selectionOption ->
                                DropdownMenuItem(
                                    text = { Text(selectionOption) },
                                    onClick = {
                                        selectedOptionText = selectionOption
                                        expanded = false
                                    },
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                )
                            }
                        }
                    }
                }
                Row {
                    var speechRate by remember { mutableFloatStateOf(0F) }
                    Text(
                        text = "Speech Rate",
                        fontSize = 36.sp,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                            .weight(0.6F)
                    )
                    Slider(
                        value = speechRate,
                        onValueChange = { speechRate = it },
                        valueRange = -2.0F..2.0F,
                        modifier = Modifier.weight(0.4F)
                    )
                }
                Row {
                    var speechPitch by remember{ mutableFloatStateOf(0F)}
                    Text(
                        text = "Speech Pitch",
                        fontSize = 36.sp,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically).weight(0.6F)
                    )
                    Slider(
                        value = speechPitch,
                        onValueChange = { speechPitch = it },
                        valueRange = -2.0F..2.0F,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically).weight(0.4F)
                    )
                }
                Spacer(modifier = Modifier.weight(1F))
                Row(modifier = Modifier.fillMaxWidth(0.98F)) {
                    var stairPref by remember { mutableStateOf(true) }
                    Text(
                        text = "Avoid stairs",
                        fontSize = 20.sp,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1F))
                    Switch(checked = stairPref, onCheckedChange = { stairPref = it })
                }
                Row(modifier = Modifier.fillMaxWidth(0.98F)) {
                    var favRoutePref by remember { mutableStateOf(true) }
                    Text(
                        text = "Predict favorable route",
                        fontSize = 20.sp,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1F))
                    Switch(checked = favRoutePref, onCheckedChange = { favRoutePref = it })
                }
                Row(modifier = Modifier.fillMaxWidth(0.98F)) {
                    var cameraPref by remember { mutableStateOf(true) }
                    Text(
                        text = "Use camera to detect obstacles",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1F))
                    Switch(checked = cameraPref, onCheckedChange = { cameraPref = it })
                }
            }

        }
    }
}

@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(navController = rememberNavController())
}