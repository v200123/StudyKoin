package com.lc.koin.bean
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/**
 *@author LC
 *@createTime 2020/7/30 10:28
 *@description  描述文件
 */
@JsonClass(generateAdapter = true)
data class PreFIrUploadModel(
    @Json(name = "app_user_id")
    var mAppUserId: String = "", // 5ddb3949b2eb466d4c68779c
    @Json(name = "cert")
    var mCert: Cert = Cert(),
    @Json(name = "download_domain")
    var mDownloadDomain: String = "", // d.firim.info
    @Json(name = "download_domain_https_ready")
    var mDownloadDomainHttpsReady: Boolean = false, // true
    @Json(name = "form_method")
    var mFormMethod: String = "", // POST
    @Json(name = "id")
    var mId: String = "", // 5f222fb9b2eb46056525d617
    @Json(name = "short")
    var mShort: String = "", // s9jr
    @Json(name = "storage")
    var mStorage: String = "", // qiniu
    @Json(name = "type")
    var mType: String = "", // android
    @Json(name = "user_system_default_download_domain")
    var mUserSystemDefaultDownloadDomain: String = "" // d.firim.info
) {
    @JsonClass(generateAdapter = true)
    class Cert(
        @Json(name = "binary")
        var mBinary: Binary = Binary(),
        @Json(name = "icon")
        var mIcon: Icon = Icon(),
        @Json(name = "mqc")
        var mMqc: Mqc = Mqc(),
        @Json(name = "prefix")
        var mPrefix: String = "", // x:
        @Json(name = "support")
        var mSupport: String = "" // qiniu
    ) {
        @JsonClass(generateAdapter = true)
        class Binary(
            @Json(name = "custom_headers")
            var mCustomHeaders: CustomHeaders = CustomHeaders(),
            @Json(name = "key")
            var mKey: String = "", // 2126056db09afbe741e7c80ebee23fe1023c711c.apk
            @Json(name = "token")
            var mToken: String = "", // _Vr9k9CbrqN6dKAd18Ezner7W9yR86vNze9XcT9h:f2V099eiB4NYjIoOc5WqNRdmnRg=:eyJzY29wZSI6InByby1hcHA6MjEyNjA1NmRiMDlhZmJlNzQxZTdjODBlYmVlMjNmZTEwMjNjNzExYy5hcGsiLCJjYWxsYmFja1VybCI6Imh0dHA6Ly9hcGkuamFwcHN0b3JlLmNvbS9hdXRoL3Fpbml1L2NhbGxiYWNrP3BhcmVudF9pZD01ZjIyMmZiOWIyZWI0NjA1NjUyNWQ2MTdcdTAwMjZ0aW1lc3RhbXA9MTU5NjA3NTk2MVx1MDAyNnNpZ249OWRhOWFcdTAwMjZ1c2VyX2lkPTVkZGIzOTQ5YjJlYjQ2NmQ0YzY4Nzc5YyIsImNhbGxiYWNrQm9keSI6ImtleT0kKGtleSlcdTAwMjZldGFnPSQoZXRhZylcdTAwMjZmc2l6ZT0kKGZzaXplKVx1MDAyNmZuYW1lPSQoZm5hbWUpXHUwMDI2b3JpZ2luPSQoeDpvcmlnaW4pXHUwMDI2bmFtZT0kKHg6bmFtZSlcdTAwMjZidWlsZD0kKHg6YnVpbGQpXHUwMDI2dmVyc2lvbj0kKHg6dmVyc2lvbilcdTAwMjZpc191c2VfbXFjPSQoeDppc191c2VfbXFjKVx1MDAyNmNoYW5nZWxvZz0kKHg6Y2hhbmdlbG9nKVx1MDAyNnJlbGVhc2VfdHlwZT0kKHg6cmVsZWFzZV90eXBlKVx1MDAyNmRpc3RyaWJ1dGlvbl9uYW1lPSQoeDpkaXN0cmlidXRpb25fbmFtZSlcdTAwMjZzdXBwb3J0ZWRfcGxhdGZvcm09JCh4OnN1cHBvcnRlZF9wbGF0Zm9ybSlcdTAwMjZtaW5pbXVtX29zX3ZlcnNpb249JCh4Om1pbmltdW1fb3NfdmVyc2lvbilcdTAwMjZ1aV9yZXF1aXJlZF9kZXZpY2VfY2FwYWJpbGl0aWVzPSQoeDp1aV9yZXF1aXJlZF9kZXZpY2VfY2FwYWJpbGl0aWVzKVx1MDAyNnVpX2RldmljZV9mYW1pbHk9JCh4OnVpX2RldmljZV9mYW1pbHkpIiwiZGVhZGxpbmUiOjE1OTYwNzk1NjEsInVwaG9zdHMiOlsiaHR0cDovL3VwLnFpbml1LmNvbSIsImh0dHA6Ly91cGxvYWQucWluaXUuY29tIiwiLUggdXAucWluaXUuY29tIGh0dHA6Ly8xODMuMTMxLjcuMyJdLCJnbG9iYWwiOmZhbHNlfQ==
            @Json(name = "upload_url")
            var mUploadUrl: String = "" // https://upload.qbox.me
        ) {
            @JsonClass(generateAdapter = true)
            class CustomHeaders(
            )
        }

        @JsonClass(generateAdapter = true)
        class Icon(
            @Json(name = "custom_headers")
            var mCustomHeaders: CustomHeaders = CustomHeaders(),
            @Json(name = "key")
            var mKey: String = "", // d1e99c9f4723300e29f2999f57be88287e6ea665
            @Json(name = "token")
            var mToken: String = "", // _Vr9k9CbrqN6dKAd18Ezner7W9yR86vNze9XcT9h:gucB1g8m8F2l8XS7VaLUxkMASP8=:eyJzY29wZSI6ImZpcmljb246ZDFlOTljOWY0NzIzMzAwZTI5ZjI5OTlmNTdiZTg4Mjg3ZTZlYTY2NSIsImNhbGxiYWNrVXJsIjoiaHR0cDovL2FwaS5qYXBwc3RvcmUuY29tL2F1dGgvcWluaXUvY2FsbGJhY2s_cGFyZW50X2lkPTVmMjIyZmI5YjJlYjQ2MDU2NTI1ZDYxN1x1MDAyNnRpbWVzdGFtcD0xNTk2MDc1OTYxXHUwMDI2c2lnbj05ZGE5YVx1MDAyNm9yaWdpbmFsX2tleT0iLCJjYWxsYmFja0JvZHkiOiJrZXk9JChrZXkpXHUwMDI2ZXRhZz0kKGV0YWcpXHUwMDI2ZnNpemU9JChmc2l6ZSlcdTAwMjZmbmFtZT0kKGZuYW1lKVx1MDAyNm9yaWdpbj0kKHg6b3JpZ2luKVx1MDAyNmlzX2NvbnZlcnRlZD0kKHg6aXNfY29udmVydGVkKSIsImRlYWRsaW5lIjoxNTk2MDc2NTYxLCJ1cGhvc3RzIjpbImh0dHA6Ly91cC5xaW5pdS5jb20iLCJodHRwOi8vdXBsb2FkLnFpbml1LmNvbSIsIi1IIHVwLnFpbml1LmNvbSBodHRwOi8vMTgzLjEzMS43LjMiXSwiZ2xvYmFsIjpmYWxzZX0=
            @Json(name = "upload_url")
            var mUploadUrl: String = "" // https://upload.qbox.me
        ) {
            @JsonClass(generateAdapter = true)
            class CustomHeaders(
            )
        }

        @JsonClass(generateAdapter = true)
        class Mqc(
            @Json(name = "is_mqc_availabled")
            var mIsMqcAvailabled: Boolean = false, // true
            @Json(name = "total")
            var mTotal: Int = 0, // 5
            @Json(name = "used")
            var mUsed: Int = 0 // 0
        )
    }
}