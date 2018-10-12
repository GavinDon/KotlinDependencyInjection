package com.gavin.kotlindependencyinjection.network

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gavin.kotlindependencyinjection.R
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference


/**
 * description: compose
 * Created by liNan on 2018/8/15 11:28

 */
class RxScheduler {
    companion object {
        fun <T> applyScheduler(): ObservableTransformer<T, T> {
            return ObservableTransformer {
                it.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        fun <T> applySingle(): SingleTransformer<T, T> {
            return SingleTransformer {
                it.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        /**
         * dialog
         */
        fun <T> applyDialog(context: Context, loadText: String = "加载中"): SingleTransformer<T, T> {
            val activityWeakReference = WeakReference(context)
//            val progressBar = MaterialDialog(activityWeakReference.get()!!)
//                    .show {
//
//                    }
//                    .progress(true, 100, true)
//                    .progressNumberFormat("%1d/%2d")
//                    .content("$loadText...")
//                    .build()
            val loadingView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
            val window =  (context as Activity).window
            window.addContentView(loadingView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

//            progressBar.show()
            return SingleTransformer { upstream ->
//                upstream.doOnEach {
//                    //progressBar.show() //显示时会慢一点出来
//                }.doOnTerminate {
////                    progressBar.dismiss()
//                }.doOnSubscribe {
////                    progressBar.dismiss()
//                }
                upstream.doFinally {
                    Log.i("FUEL","finally")
                }
            }
        }
    }
}