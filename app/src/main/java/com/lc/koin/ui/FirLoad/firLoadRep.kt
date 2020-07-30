package com.lc.koin.ui.FirLoad

import androidx.lifecycle.MutableLiveData
import com.lc.koin.base.ApiException
import com.lc.koin.base.BaseRepository
import com.lc.koin.bean.FirVersionBean
import com.lc.koin.bean.PreFIrUploadModel
import com.lc.koin.http.getHttpClient
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.CoroutineScope

/**
 *@author LC
 *@createTime 2020/7/29 16:32
 *@description  描述文件
 */
class firLoadRep(coroutineScope: CoroutineScope, errorLiveData: MutableLiveData<ApiException>) :
    BaseRepository(coroutineScope, errorLiveData) {
    private val mKey = MMKV.mmkvWithID("fir")
     val KEY_FIR_ID = "com.koin.firID"
     val KEY_FIR_Token = "com.koin.firToken"
    fun getVersion(id: String, apiToken: String, versionBean: MutableLiveData<FirVersionBean>) {
        launch(
            block = {
                getHttpClient().getVersion(id, apiToken)
            },success = {
                versionBean.postValue(it)
            }
        )
    }

    fun getPreInfo( apiToken: String, versionBean: MutableLiveData<PreFIrUploadModel>){
        launch(
            block = {
                getHttpClient().getUploadToken( Token = apiToken,bundle_id = "1")
            },success = {
                versionBean.postValue(it)
            }
        )
    }

    fun uploadImage(imageUrl:String,)

    fun getId()=
        if (mKey.containsKey(KEY_FIR_ID))
        {
            mKey.decodeString(KEY_FIR_ID)
        }else{
           null
        }
    fun getToken()=
        if (mKey.containsKey(KEY_FIR_Token))
        {
            mKey.decodeString(KEY_FIR_Token)
        }else{
           null
        }


}