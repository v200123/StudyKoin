package com.lc.mylibrary

import android.util.Log
import java.util.logging.Logger

/**
 *@author LC
 *@createTime 2020/7/21 11:59
 *@description
 */


fun <T>T.dOut(){
    Log.d("com.log.util",this.toString())
}