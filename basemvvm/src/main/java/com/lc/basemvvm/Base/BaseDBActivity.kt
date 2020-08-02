package com.lc.basemvvm.Base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *@author LC
 *@createTime 2020/8/1 16:29
 *@description  描述文件
 */
abstract class BaseDBActivity<DB : ViewDataBinding>() : BaseActivity(0) {

    //     val mActivityProvider by lazy {  ViewModelProvider(this) }
    lateinit var mDataBind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        initViewModel()
        initView()
        observed()
    }

    fun setContentView() {
        mDataBind = DataBindingUtil.setContentView(this, getLayoutId())
    }

    open fun initViewModel() {

    }

    abstract fun observed()
    abstract fun initView()

    abstract fun getLayoutId(): Int


}