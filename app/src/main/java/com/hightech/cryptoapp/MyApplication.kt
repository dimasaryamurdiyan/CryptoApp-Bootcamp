package com.hightech.cryptoapp

import android.app.Application
import com.hightech.cryptoapp.frameworks.DbFactory

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DbFactory.application = this
        instance = this

    }

    companion object {
        var instance: MyApplication? = null
    }
}