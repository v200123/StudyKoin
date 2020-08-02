package com.lc.koin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import com.chad.library.adapter.base.BaseQuickAdapter
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.heytap.msp.push.HeytapPushManager
import com.heytap.msp.push.callback.ICallBackResultService
import com.lc.koin.bean.testBean
import com.lc.koin.http.getHttpClient
import com.lc.mylibrary.checkStorageModel
import com.lc.mylibrary.dOut
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext
import org.koin.core.parameter.parametersOf
import org.koin.experimental.property.inject
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    private val test by  inject<testBean>(parameters = { parametersOf("李四") })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVersion()
        initOPPOPush()
        initChannel()
        immersionBar{
            statusBarDarkFont(false)
            barColor(R.color.colorPrimary)
        }
    }

    private fun initVersion() {
        "当前的存储运行状态${checkStorageModel()}".dOut()
    }

    private fun initChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel("1", name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

    private fun initOPPOPush() {
        HeytapPushManager.init(this,true)
        if(HeytapPushManager.isSupportPush())
        {
            HeytapPushManager.register(this,"c78c5628e6a44b81a82590b094078707","2806115311c242169d010a5a9bab82bc",object : ICallBackResultService{
                override fun onGetPushStatus(p0: Int, p1: Int) {

                    if(p0 != 0)
                    {
                        "请求不成功,当前的Push状态是$p0".dOut()
                    }

                        "获取到当前的状态${when(p1){
                            0->"开始"
                            1->"暂停"
                            2->"停止"
                            else ->"未知错误"
                        }}".dOut()
                }

                override fun onSetPushTime(p0: Int, p1: String?) {
                }

                override fun onGetNotificationStatus(p0: Int, p1: Int) {
                }

                override fun onUnRegister(p0: Int) {
                }

                override fun onRegister(p0: Int, p1: String?) {
                    if(p0 != 0)
                    {
                        "请求不成功,当前的状态是$p0".dOut()
                    }
                    "已经获取到了registeredID\t:$p1".dOut()
                }

            })
        }
        else{
            "不支持该手机推送".dOut()
        }
    }
}