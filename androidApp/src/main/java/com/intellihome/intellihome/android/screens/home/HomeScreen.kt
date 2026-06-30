package com.intellihome.intellihome.android.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.intellihome.intellihome.android.composables.DeviceCard
import com.intellihome.intellihome.android.theme.IntelliHomeTheme
import com.intellihome.intellihome.android.theme.spacing
import com.intellihome.intellihome.data.entity.Device
import com.intellihome.intellihome.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Loading...", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight()
                .padding(all = MaterialTheme.spacing.medium)
        ) {
            Text("Devices", fontSize = 30.sp)

            LazyVerticalGrid(
                columns = GridCells.Adaptive(170.dp)
            ) {
                itemsIndexed(state.devices) { index, device ->
                    DeviceCard(
                        device = device,
                        onClick = {clickedDevice ->
                            navController.navigate(
                                "device/${clickedDevice.id}/${clickedDevice.name}"
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun HomeScreenPreview() {
    IntelliHomeTheme { HomeScreen(navController = rememberNavController()) }
}
