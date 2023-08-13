package com.hightech.cryptoapp

import android.app.Application

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: MyApplication? = null
    }
}