package com.lc.koin.ui.firload

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.storage.StorageManager.EXTRA_REQUESTED_BYTES
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.lc.basemvvm.Base.BaseDBFragment
import com.lc.koin.R
import com.lc.koin.bean.PreFIrUploadModel
import com.lc.koin.databinding.FragmentFirLoadBinding
import com.lc.mylibrary.CHECK_CAPACITY
import com.lc.mylibrary.checkStorageCapacity
import com.lc.mylibrary.dOut
import com.tencent.mmkv.MMKV
//import javafx.scene.Cursor.cursor
import kotlinx.android.synthetic.main.dialog_fir_intput.*
import kotlinx.android.synthetic.main.fragment_fir_load.*
import org.koin.android.ext.android.bind


/**
 *@author LC
 *@createTime 2020/7/29 15:45
 *@description  描述文件
 */
class firUpLoadFragment : BaseDBFragment() {
    private val mfirViewModel by viewModels<FirViewModel>()
    private lateinit var mContext: Context
    private lateinit var preFIrUploadModel: PreFIrUploadModel
    override fun getLayoutId(): Int  = R.layout.fragment_fir_load

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onResume() {
        super.onResume()
        (binding as FragmentFirLoadBinding).viewmodel = mfirViewModel

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initArgumentCheck()
        try {
            mfirViewModel.getVersion()

        }catch (e:Exception){
            InputDialogFragment(mfirViewModel).show(childFragmentManager, "sdfsdf")
        }
//        mfirViewModel.mLiveData.observe(this, Observer {
//            tv_version.text = """应用的名称是:${it.mName}
//应用的版本号是：${it.mVersion ?: "sdfsdfs"}
//应用的下载地址是:${it.mNewInstallUrl}""".trimMargin()
//        })

        mfirViewModel.mPreData.observe(this, Observer {
            preFIrUploadModel = it
            startActivityForResult(Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                setType("*/*")
                putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
                addCategory(Intent.CATEGORY_OPENABLE)
            }, 400)
          })

        mfirViewModel.mFileLive.observe(this, Observer {
            mfirViewModel.uploadFile(preFIrUploadModel.mCert.mBinary.mUploadUrl,preFIrUploadModel.mCert.mBinary.mKey,preFIrUploadModel.mCert.mBinary.mToken,it)
        })
    }

    private fun initArgumentCheck() {
        MMKV.mmkvWithID("fir").apply {
            if (!this.containsKey("com.koin.firID")) {
                InputDialogFragment(mfirViewModel).show(childFragmentManager, "sdfsdf")
            }
        }

//        (mContext as AppCompatActivity).checkStorageCapacity()

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

        btn_jump.setOnClickListener {
            findNavController().navigate(R.id.action_firUpLoadFragment_to_contentFragment)
        }

        button2.setOnClickListener {
            mfirViewModel.getPreInfo()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            // 用户未选择任何文件，直接返回
            return;
        }
        if (requestCode ==400 ) {
            data.data.apply {
                this.dOut()
//                val openFileDescriptor = mContext.contentResolver.openFileDescriptor(this!!, "r")
//               mfirViewModel.mFileLive.postValue(File(this!!.path!!))
//                mFile.absoluteFile.dOut()
            }

        }
        if(requestCode == CHECK_CAPACITY){
            "当前的容量是${data.getStringExtra(EXTRA_REQUESTED_BYTES)}".dOut()
        }
    }
}


class InputDialogFragment(var mViewModel: FirViewModel) : DialogFragment() {
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