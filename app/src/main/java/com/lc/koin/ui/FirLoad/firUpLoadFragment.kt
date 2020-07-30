package com.lc.koin.ui.FirLoad

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.lc.koin.R
import com.lc.mylibrary.dOut
import com.sky.filepicker.upload.Constants
import com.sky.filepicker.upload.LocalUpdateActivity
import com.tencent.mmkv.MMKV
import kotlinx.android.synthetic.main.dialog_fir_intput.*
import kotlinx.android.synthetic.main.fragment_fir_load.*
import java.io.File

/**
 *@author LC
 *@createTime 2020/7/29 15:45
 *@description  描述文件
 */
class firUpLoadFragment : Fragment(R.layout.fragment_fir_load) {
    private val mfirViewModel by viewModels<firViewModel>()
    private lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initArgumentCheck()
        try {
            mfirViewModel.getVersion()

        }catch (e:Exception){
            InputDialogFragment(mfirViewModel).show(childFragmentManager, "sdfsdf")
        }
        mfirViewModel.mLiveData.observe(this, Observer {
            tv_version.text = """应用的名称是:${it.mName}
应用的版本号是：${it.mVersion ?: "sdfsdfs"}
应用的下载地址是:${it.mNewInstallUrl}""".trimMargin()
        })

        mfirViewModel.mPreData.observe(this, Observer {
            it.dOut()
            startActivityForResult(Intent(Intent.ACTION_GET_CONTENT).apply {
            setType("*/*")
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
            addCategory(Intent.CATEGORY_OPENABLE)
        }, 400) })
    }

    private fun initArgumentCheck() {
        MMKV.mmkvWithID("fir").apply {
            if (!this.containsKey("com.koin.firID")) {
                InputDialogFragment(mfirViewModel).show(childFragmentManager, "sdfsdf")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ChangeId()
    }

    fun ChangeId() {
        btn_edit_id.setOnClickListener {
            InputDialogFragment(mfirViewModel).show(
                childFragmentManager,
                "sdfsdf"
            )
        }
        button2.setOnClickListener {
            mfirViewModel.getPreInfo()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==400 ) {
            val data1 = data!!.data
            val openFileDescriptor = mContext.contentResolver.openFileDescriptor(data1!!, "r")
        }
    }
}


class InputDialogFragment(var mViewModel: firViewModel) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fir_intput, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_ensure.setOnClickListener {
            MMKV.mmkvWithID("fir").apply { encode("com.koin.firID", et_fir_id.text.toString())
            encode("com.koin.firToken",et_fir_token.text.toString())}
            mViewModel.mLiveId.value = et_fir_id.text.toString()
            mViewModel.mLiveToken.value = et_fir_token.text.toString()
            mViewModel.getVersion()
            this.dismiss()
        }
    }


}