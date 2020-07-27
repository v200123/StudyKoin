package com.example.mykotlinapp

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.VirtualLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileOutputStream
import java.util.logging.Formatter


class MainActivity : AppCompatActivity() {
val layoutmanage = VirtualLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(getDataTotalSize(this))
        Myrecycleview.layoutManager = layoutmanage
        val  pool:RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
        Myrecycleview.setRecycledViewPool(pool)
        
    }
    fun getDataTotalSize(context: Context): String? {
        val sf = StatFs( Environment.getDataDirectory().path)
        val blockSize = sf.blockSizeLong
        val totalBlocks = sf.blockCountLong
        val abailableBlocks = sf.availableBlocksLong
        return  ((blockSize * abailableBlocks)/1024/1024).toString()
    }
}
