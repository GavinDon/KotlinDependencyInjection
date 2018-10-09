package com.gavin.kotlindependencyinjection.utils

import android.view.View
import com.github.kittinunf.fuel.core.Request

/**
 * description:
 * Created by liNan on 2018/9/19 14:33

 */
private lateinit var mList: ArrayList<Request>

fun View.dip2px(dipValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

fun View.px2dip(pxValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

/**
 * 添加请求对象 方便在onDestroy时取消请求
 */
fun Request.addList(): Request {
    if (!::mList.isInitialized) {
        mList = arrayListOf()
    } else {
        mList.add(this)
    }
    return this
}

fun getRequestList(): ArrayList<Request> {
    return if (!::mList.isInitialized) {
        arrayListOf()
    } else {
        mList
    }

}


