package com.intellihome.intellihome.android.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.intellihome.intellihome.android.composables.DeviceCard
import com.intellihome.intellihome.android.theme.IntelliHomeTheme
import com.intellihome.intellihome.data.entity.Device
import com.intellihome.intellihome.presentation.viewmodel.HomeViewModel

@Composable
fun DeviceScreen(
    viewModel: HomeViewModel = viewModel(),
    id: String,
    name: String
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
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Device", fontSize = 30.sp)
            Spacer(Modifier.height(100.dp))
            Text("Id: $id, Name: $name")
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun DeviceScreenPreview() {
    IntelliHomeTheme { DeviceScreen(id="1", name="Device1") }
}
