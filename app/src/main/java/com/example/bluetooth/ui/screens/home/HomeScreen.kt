package com.example.bluetooth.ui.screens.home

import android.Manifest
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bluetooth.ui.theme.BluetoothTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    var permissions = listOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        permissions = permissions.plus(
            listOf(
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_CONNECT,
            ),
        )
    }
    val permissionsState = rememberMultiplePermissionsState(
        permissions = permissions,
    )

    Column(modifier = modifier) {
        Button(onClick = { viewModel.startScan() }) {
            Text(text = "Start")
        }
        Button(onClick = { viewModel.stopScan() }) {
            Text(text = "Stop")
        }
        Button(onClick = { permissionsState.launchMultiplePermissionRequest() }) {
            Text(text = "Request permissions")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BluetoothTheme {
        HomeScreen()
    }
}