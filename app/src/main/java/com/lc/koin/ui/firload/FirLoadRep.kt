package com.lc.koin.ui.firload

import androidx.lifecycle.MutableLiveData
import com.lc.koin.base.ApiException
import com.lc.koin.base.BaseRepository
import com.lc.koin.bean.FirVersionBean
import com.lc.koin.bean.PreFIrUploadModel
import com.lc.koin.http.getHttpClient
import com.lc.mylibrary.dOut
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.CoroutineScope
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 *@author LC
 *@createTime 2020/7/29 16:32
 *@description  描述文件
 */
class FirLoadRep(coroutineScope: CoroutineScope, errorLiveData: MutableLiveData<ApiException>) :
    BaseRepository(coroutineScope, errorLiveData) {
    private val mKey = MMKV.mmkvWithID("fir")
     val KEY_FIR_ID = "com.koin.firID"
     val KEY_FIR_Token = "com.koin.firToken"
    fun getVersion(id: String, apiToken: String, versionBean: MutableLiveData<FirVersionBean>) {
        launch(
            block = {
                getHttpClient().getVersion(id, apiToken)
            },success = {
                it.dOut()
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

//    fun uploadImage(imageUrl:String,)

    fun uploadFile(url:String,key:String,Token:String,file: File){
        launch(
            block = {
                val create = RequestBody.create(MediaType.parse("multipart/form-data"), file)
                val createFormData = MultipartBody.Part.createFormData("file", file.name, create)
                getHttpClient().uploadIcon(url,key,Token,"哈哈","0001","001","使用API上传的APK",createFormData)
            },success = {
                
            }
        )
    }
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