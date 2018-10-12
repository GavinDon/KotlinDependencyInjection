package com.gavin.kotlindependencyinjection.utils

import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.gavin.kotlindependencyinjection.R
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response

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

fun MaterialDialog.showLoading() {
    this.customView(R.layout.dialog_loading)
            .show()
}

 fun  responseInterceptor() = { next: (Request, Response) -> Response ->
    { req: Request, res: Response ->
        println(res.toString())
        println(req.toString())
        next(req, res)
    }
}




