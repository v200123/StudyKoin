package com.lc.koin.http

import com.lc.koin.bean.FirVersionBean
import com.lc.koin.bean.PreFIrUploadModel
import okhttp3.MultipartBody
import retrofit2.http.*

/**
 *@author LC
 *@createTime 2020/7/27 22:38
 *@description  描述文件
 */
interface FirApiInterface {
    @GET("apps/latest/{id}")
   suspend fun getVersion(@Path("id")id:String,@Query("api_token")api_token:String):FirVersionBean

    @POST("apps")
    suspend fun getUploadToken(@Query("type")type:String = "android",@Query("api_token")Token:String,@Query("bundle_id")bundle_id:String):PreFIrUploadModel
    @Multipart
    @POST
    suspend fun uploadIcon(@Url url:String, @Query("key")key:String, @Query("token")token:String, @Query("x:name")name:String?,
        @Query("x:version")version:String?,
        @Query("x:build")build:String?,
        @Query("x:changelog")change:String?
        , @Part file:MultipartBody.Part)
}