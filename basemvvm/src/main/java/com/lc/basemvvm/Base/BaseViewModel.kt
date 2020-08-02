package com.lc.basemvvm.Base

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

/**
 *@author LC
 *@createTime 2020/8/1 17:08
 *@description  描述文件
 */

typealias LaunchBlock = suspend CoroutineScope.() -> Unit

typealias EmitBlock<T> = suspend LiveDataScope<T>.() -> T

typealias Cancel = (e: Exception) -> Unit

abstract class BaseViewModel<T:BaseRepository>: ViewModel() {
    val mStateLiveData = MutableLiveData<StateActionEvent>()
    val mRep:T by lazy { initRepository() }
    abstract fun initRepository():T
}