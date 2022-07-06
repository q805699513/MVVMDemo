package com.longsh.mvvm

import android.app.Application

/**
 * @author LongShaoHua
 * @date 20-11-24
 */
class MyApplication : Application() {

    companion object {
        var instance: Application? = null
        fun getContext() = instance!!
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}