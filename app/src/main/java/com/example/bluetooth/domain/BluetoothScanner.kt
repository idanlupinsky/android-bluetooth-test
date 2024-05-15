package com.example.bluetooth.domain

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.util.Log

class BluetoothScanner(private val bluetoothAdapter: BluetoothAdapter) {
    private val TAG = "BluetoothScanner"

    private val scanSettings = ScanSettings.Builder()
        .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
        .build()

    private val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            super.onScanResult(callbackType, result)
            Log.i(TAG, "onScanResult: callbackType: $callbackType, result: $result")
        }

        override fun onBatchScanResults(results: MutableList<ScanResult>?) {
            super.onBatchScanResults(results);
            Log.i(TAG, "onBatchScanResults: $results")
        }

        override fun onScanFailed(errorCode: Int) {
            super.onScanFailed(errorCode)
            Log.e(TAG, "onScanFailed: $errorCode")
        }
    }

    @SuppressLint("MissingPermission")
    fun startScan() {
        Log.i(TAG, "startScan: btEnabled ${bluetoothAdapter.isEnabled}")
//        bluetoothAdapter.bluetoothLeScanner?.startScan(null, scanSettings, scanCallback)
        bluetoothAdapter.bluetoothLeScanner?.startScan(scanCallback)
    }

    @SuppressLint("MissingPermission")
    fun stopScan() {
        Log.i(TAG, "stopScan")
        bluetoothAdapter.bluetoothLeScanner?.stopScan(scanCallback)
    }
}