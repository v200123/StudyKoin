package com.lc.koin.http

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *@author LC
 *@createTime 2020/7/27 23:16
 *@description  描述文件
 */
fun getHttpClient():FirApiInterface=

    Retrofit.Builder().baseUrl("http://api.bq04.com/").addConverterFactory(MoshiConverterFactory.create()).build().create(FirApiInterface::class.java)

