package com.lc.basemvvm.Base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *@author LC
 *@createTime 2020/8/2 16:12
 *@description  描述文件
 * @param contentLayoutId 如果不需要默认设置，将Int传为0就可以了
 */
abstract class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    abstract fun initData(savedInstanceState: Bundle?)

//    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData(savedInstanceState)
    }
}