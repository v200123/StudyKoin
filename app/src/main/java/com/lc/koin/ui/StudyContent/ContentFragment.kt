package com.lc.koin.ui.StudyContent

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.fragment.app.Fragment
import com.lc.koin.R
import com.lc.mylibrary.dOut
import kotlinx.android.synthetic.main.fragment_study_content.*
import java.math.MathContext

/**
 *@author LC
 *@createTime 2020/7/31 10:26
 *@description  描述文件
 */
class ContentFragment : Fragment(R.layout.fragment_study_content) {
    private lateinit var mContext:Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getContact()
        btn_get_info.setOnClickListener {
            getContact()
        }

    }

    private fun getContact() {
        val query = mContext.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        if (query != null) {
            while (query.moveToNext()) {
                """
                            当前的通讯录中有：姓名：${query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))}
                            手机号:${query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))}
                        """.trimIndent().dOut()
            }
            query.close()
        }
    }
}