package com.lc.versionplugin

import com.lc.versionplugin.VersionControllor.version.appCompatVersion
import com.lc.versionplugin.VersionControllor.version.constraintlayoutVersion
import com.lc.versionplugin.VersionControllor.version.koinVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.impldep.com.esotericsoftware.minlog.Log

/**
 *@author LC
 *@createTime 2020/7/20 21:39
 *@description
 */
class VersionControllor : Plugin<Project> {
    override fun apply(p0: Project) {
        println("当前我的名字是${p0.name}，是一个管理依赖库的版本的")
    }
private object version{
    val appCompatVersion = "1.2.0-rc01"
    val constraintlayoutVersion = "1.1.3"
    val ktxCoretVersion = "1.3.0"
    val koinVersion = "2.1.5"
    val oppoVersion = "2.0.2"
    val BRAVHVersion = "3.0.4"
    val RETROFITVersion = "2.9.0"

}

 object AndroidX {
     val appCompat = "androidx.appcompat:appcompat:${appCompatVersion}"
     val constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"
     val ktxCore = "androidx.core:core-ktx:${version.ktxCoretVersion}"
 }

    object koin{
        val koinAndroid = "org.koin:koin-android:$koinVersion"
        val koinAndroidxViewmodel = "org.koin:koin-androidx-viewmodel:$koinVersion"
        val koinExt = "org.koin:koin-androidx-ext:$koinVersion"
    }
    object dependance{
        val BRAVH = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${version.BRAVHVersion}"
        val RETROFIT = "com.squareup.retrofit2:retrofit:${version.RETROFITVersion}"
        val MOSHI= "com.squareup.retrofit2:converter-moshi:${version.RETROFITVersion}"
    }

    object oppo{
        val oppoPush = "com.heytap.mcssdk:mcssdk:${version.oppoVersion}"
    }

}