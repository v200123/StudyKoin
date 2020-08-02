package com.lc.koin.ui.firload

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lc.koin.base.BaseViewModel
import com.lc.koin.bean.FirVersionBean
import com.lc.koin.bean.PreFIrUploadModel
import java.io.File
import java.lang.IllegalArgumentException

/**
 *@author LC
 *@createTime 2020/7/29 16:44
 *@description  描述文件
 */
class FirViewModel : BaseViewModel() {
    private val mfirLoadRep by lazy { FirLoadRep(viewModelScope,errorLiveData) }
    val mLiveData = MutableLiveData<FirVersionBean>()
    val mPreData = MutableLiveData<PreFIrUploadModel>()
    val mLiveId = MutableLiveData<String>(mfirLoadRep.getId())
    val mLiveToken = MutableLiveData<String>(mfirLoadRep.getToken())
    val mFileLive = MutableLiveData<File>()

fun getVersion(){
    if(mLiveId.value == null)
    {
        throw IllegalArgumentException("没有ID")
    }
    if(mLiveToken.value == null)
    {
        throw IllegalArgumentException("没有Token")
    }

    mfirLoadRep.getVersion(mLiveId.value!!,mLiveToken.value!!,mLiveData)

}

fun getPreInfo(){
    if(mLiveToken.value == null)
    {
        throw IllegalArgumentException("没有Token")
    }
    mfirLoadRep.getPreInfo(mLiveToken.value!!,mPreData)
}

fun uploadFile(url:String,key:String,token:String,file: File){
    mfirLoadRep.uploadFile(url,key,token,file = file)
}
}