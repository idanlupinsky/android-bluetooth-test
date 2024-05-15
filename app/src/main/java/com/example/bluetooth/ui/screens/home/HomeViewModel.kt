package com.example.bluetooth.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.bluetooth.domain.BluetoothScanner

class HomeViewModel(private val bluetoothScanner: BluetoothScanner) : ViewModel() {
    fun startScan() {
        bluetoothScanner.startScan()
    }

    fun stopScan() {
        bluetoothScanner.stopScan()
    }
}