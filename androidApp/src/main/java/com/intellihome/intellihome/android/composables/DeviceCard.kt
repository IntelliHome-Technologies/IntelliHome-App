package com.intellihome.intellihome.android.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.intellihome.intellihome.android.theme.spacing
import com.intellihome.intellihome.data.entity.Device

@Composable
fun DeviceCard(
    device: Device,
    modifier: Modifier = Modifier,
    onClick: (Device) -> Unit
) {
    Card (
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(all = MaterialTheme.spacing.medium),
        shape = MaterialTheme.shapes.medium,
        onClick = { onClick(device) },
    ) {
        Text(device.name, style = MaterialTheme.typography.bodyMedium)
    }
}