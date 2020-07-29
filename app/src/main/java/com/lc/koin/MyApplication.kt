package com.lc.koin

import android.app.Application
import android.content.Context
import com.lc.koin.module.personModule
import com.lc.mylibrary.dOut
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 *@author LC
 *@createTime 2020/7/12 14:54
 *@description
 */
class MyApplication : Application() {



    companion object{
       lateinit var mBaseContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this).dOut()


        mBaseContext = this
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(personModule)

        }
    }
}