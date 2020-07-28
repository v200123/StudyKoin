package com.lc.koin.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/**
 *@author LC
 *@createTime 2020/7/27 22:22
 *@description  描述文件
 */
@JsonClass(generateAdapter = true)
 data class FirVersionBean(
    @Json(name = "binary")
    var mBinary: Binary = Binary(),
    @Json(name = "build")
    var mBuild: String = "", // 6
    @Json(name = "changelog")
    var mChangelog: String = "", // 更新日志
    @Json(name = "installUrl")
    var mInstallUrl: String = "", // http://download.bq04.com/v2/app/install/xxxxxxxxxxxxxxxxxxxx?download_token=xxxxxxxxxxxxxxxxxxxxxxxxxxxx
    @Json(name = "install_url")
    var mNewInstallUrl: String = "", // http://download.bq04.com/v2/app/install/xxxxxxxxxxxxxxxx?download_token=xxxxxxxxxxxxxxxxxxxxxxxxxxxx
    @Json(name = "name")
    var mName: String = "", // fir.im
    @Json(name = "update_url")
    var mUpdateUrl: String = "", // http://fir.im/fir
    @Json(name = "version")
    var mVersion: String = "", // 1.0
    @Json(name = "versionShort")
    var mVersionShort: String = "" // 1.0.5
) {
    @JsonClass(generateAdapter = true)
    class Binary(
        @Json(name = "fsize")
        var mFsize: Int = 0 // 6446245
    )
}