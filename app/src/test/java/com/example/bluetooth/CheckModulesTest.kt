package com.example.bluetooth

import com.example.bluetooth.di.appModule
import org.junit.Test
import org.koin.android.test.verify.verify
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest

class CheckModulesTest : KoinTest {
    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() {
        appModule.verify()
    }
}