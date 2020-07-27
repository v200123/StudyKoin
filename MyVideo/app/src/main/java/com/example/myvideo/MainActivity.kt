package com.example.myvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dueeeke.videoplayer.player.VideoView

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        video_player.setUrl("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4")
        video_player.start()

    }
}
