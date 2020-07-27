package com.lc.koin.http

import com.lc.koin.bean.FirVersionBean
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *@author LC
 *@createTime 2020/7/27 22:38
 *@description  描述文件
 */
interface FirApiInterface {
    @GET("apps/latest/{id}")
   suspend fun getVersion(@Path("id")id:String,@Query("api_token")api_token:String):FirVersionBean
}