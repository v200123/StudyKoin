package com.lc.screen

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 *@author LC
 *@createTime 29 23:11
 *@description
 */
class CrossView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private var mWidth = 0
    private var mHigh = 0
    private var mRectWidth = 3f
    set(value) {
        field = value
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var mWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        when(MeasureSpec.getMode(widthMeasureSpec)){
            MeasureSpec.AT_MOST,MeasureSpec.EXACTLY ->{
                if(mWidthSize>context.resources.getDisplayMetrics().widthPixels*0.2f)
                {
                    mWidthSize = (context.resources.getDisplayMetrics().widthPixels*0.2f).toInt()
                }
            }
        }
//        when(MeasureSpec.getMode(heightMeasureSpec)){
//            MeasureSpec.AT_MOST,MeasureSpec.EXACTLY ->{
//
//            }
//        }
        setMeasuredDimension(mWidthSize,mWidthSize)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHigh = h
        println("当前的宽高分别是：$mWidth，$mHigh")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.run {
            translate((mWidth/2).toFloat(), (mHigh/2).toFloat())
            drawRect(-(mWidth/2).toFloat(),-mRectWidth,(mWidth/2).toFloat(),mRectWidth,Paint().apply {
                color = Color.WHITE
            })
            drawRect(-mRectWidth,-(mHigh/2).toFloat(),mRectWidth,(mHigh/2).toFloat(),Paint().apply {
                color = Color.WHITE
            })
        }
    }

}