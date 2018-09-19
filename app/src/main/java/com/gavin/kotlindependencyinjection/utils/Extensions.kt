package com.gavin.kotlindependencyinjection.utils

import android.view.View

/**
 * description:
 * Created by liNan on 2018/9/19 14:33

 */

fun View.dip2px(dipValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

fun View.px2dip(pxValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}