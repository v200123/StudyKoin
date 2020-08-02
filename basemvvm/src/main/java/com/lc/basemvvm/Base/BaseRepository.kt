package com.lc.basemvvm.Base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.suspendCoroutine

/**
 *@author LC
 *@createTime 2020/8/2 9:37
 *@description  描述文件
 */
open class BaseRepository(private val coroutineScope:CoroutineScope, private val mStateLiveData: MutableLiveData<StateActionEvent>) {

    fun launch(cancel: Cancel? = null, block: LaunchBlock) {//使用协程封装统一的网络请求处理
        coroutineScope.launch {
            //ViewModel自带的viewModelScope.launch,会在页面销毁的时候自动取消请求,有效封装内存泄露
            try {
                mStateLiveData.value = LoadState
                block()
                mStateLiveData.value = SuccessState
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> cancel?.invoke(e)
                    else -> mStateLiveData.value = ErrorState(e.message)
                }
            }
        }
    }

    fun <T> emit(cancel: Cancel? = null, block: EmitBlock<T>): LiveData<T> = liveData {
        try {
            mStateLiveData.value = LoadState
            emit(block())
            mStateLiveData.value = SuccessState
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> cancel?.invoke(e)
                else -> mStateLiveData.value = ErrorState(e.message)
            }
        }
    }
}