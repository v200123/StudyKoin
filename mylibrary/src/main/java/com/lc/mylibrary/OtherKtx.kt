package com.lc.mylibrary

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity

/**
 *@author LC
 *@createTime 2020/7/29 21:46
 *@description  描述文件
 */

inline fun <reified T>Context.start(block:Intent.()->Unit){
    this.startActivity(Intent(this,T::class.java).apply { block() })
}

fun checkStorageModel():String{
    if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.Q)
    {
        return if(Environment.isExternalStorageLegacy())"传统模式" else "新模式"
    }
    return "传统模式"
}