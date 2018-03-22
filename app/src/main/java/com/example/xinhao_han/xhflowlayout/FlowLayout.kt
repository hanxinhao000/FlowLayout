package com.example.xinhao_han.xhflowlayout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup



/**
 * Created by Administrator on 2017/6/6.
 */

/*
*
*   流失布局,XINHAO_HAN
* */
class FlowLayout : ViewGroup {


    var conutSize: Int = 0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    //测量位置
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        /*
               *
               * 表示当前没有孩子
               * */
        if (childCount == 0) {
            return
        }
        //记录当前所有孩子的宽度
        var childWei: Int = 0
        //记录当前多有孩子的高度
        var childHei: Int = 0
        //记录多少行
        var cout: Int = 0

        Log.e("屏幕宽度", "" + UIUtils.getWeiSize())


        for (i in 0..childCount - 1) {
            val childAt = getChildAt(i)
            val widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            val heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            childAt.measure(widthMeasureSpec, heightMeasureSpec)
            //相加当前孩子的宽高度

            Log.e("测量结果", "" + childWei)
            if (childWei < UIUtils.getWeiSize()) {
                //一行大小正好方的下,放不下就放到下一行,没毛病
                if (i == 0)
                    childAt.layout(0, (cout * childAt.measuredHeight), (childWei + childAt.measuredWidth), (cout * childAt.measuredHeight) + childAt.measuredHeight)
                else {
                    if (childWei + childAt.measuredWidth > UIUtils.getWeiSize()) {
                        //表示本行已无力吐槽,让给下一行
                        cout++
                        //记得下一行位置记录从0开始
                        childWei = 0
                        childAt.layout(childWei, (cout * childAt.measuredHeight), (childWei + childAt.measuredWidth), (cout * childAt.measuredHeight) + childAt.measuredHeight)
                    } else {
                        childAt.layout(childWei, (cout * childAt.measuredHeight), (childWei + childAt.measuredWidth), (cout * childAt.measuredHeight) + childAt.measuredHeight)
                    }
                }

                childWei += childAt.measuredWidth
            } else {
                //不能放下一行,需要换行

                //记录行数
                cout++
                //重新记录行数
                childWei = 0
            }


        }
        conutSize = cout


    }

    //测量大小,根据当前孩子View来决定自己的大小
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        /*
        *
        * 表示当前没有孩子
        * */
        if (childCount == 0) {
            return
        }
        var cout: Int = 0
        //记录当前所有孩子的宽度
        var childWei: Int = 0
        //记录当前多有孩子的高度
        var childHei: Int = 0



        for (i in 0..childCount - 1) {
            val childAt = getChildAt(i)
            childAt.measure(widthMeasureSpec, heightMeasureSpec)
            //相加当前孩子的宽高度
            childWei += childAt.measuredWidth
            childHei += childAt.measuredHeight
        }

        if (childWei > UIUtils.getWeiSize()) {
            childWei = UIUtils.getWeiSize()
        } else {

        }

        super.onMeasure(MeasureSpec.makeMeasureSpec(childWei, MeasureSpec.EXACTLY), heightMeasureSpec)
    }

}