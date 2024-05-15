package com.example.bluetooth.di

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import com.example.bluetooth.domain.BluetoothScanner
import com.example.bluetooth.ui.screens.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<BluetoothAdapter> { (androidApplication().getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter }

    single { BluetoothScanner(get()) }

    viewModel { HomeViewModel(get()) }
}