package com.gavin.kotlindependencyinjection.utils

import com.afollestad.materialdialogs.MaterialDialog
import com.gavin.kotlindependencyinjection.base.MyApplication

/**
 * description:
 * Created by liNan on 2018/10/10 17:08

 */
class LoadingDialog {
    companion object {
        fun show() {
            MaterialDialog(MyApplication.appContext).showLoading()
        }
    }

}