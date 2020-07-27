package com.lc.screen

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.heytap.wearable.support.widget.HeyDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isHide = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HeyDialog.HeyBuilder(this).setAutoDismiss(true)
            .setContentViewStyle(HeyDialog.STYLE_TITLE_CONTENT)
            .setTitle("使用指南")
            .setMessage("旨在为想在自己的影视作品中控制OPPO手表显示的内容")
            .setPositiveButton("我知道了", null).create().show()
        val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.top_out)
    Fragment
        cs_change.setOnClickListener {

            if (isHide) {
                msw_main.visibility = View.GONE
                isHide = false
            } else {
                msw_main.visibility = View.VISIBLE
                isHide = true
            }
            loadAnimation.start()


        }


        msw_main.apply {
            startAnimation(loadAnimation)
            heySwitch.isChecked = false
            heySwitch.setOnClickListener {
                if (this.heySwitch.isChecked) {
                    cs_change.setBackgroundColor(getColor(R.color.screen_blue))
                    this.summaryTextView.text = "切换为绿"
                } else {
                    cs_change.setBackgroundColor(getColor(R.color.screen_green))
                    this.summaryTextView.text = "切换为蓝"
                }
            }
        }

    }
}
