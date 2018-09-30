package com.gavin.kotlindependencyinjection.network

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


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

        /**
         * dialog
         */
/*        fun <T> applyDialog(context: Context, loadText: String = "加载中"): ObservableTransformer<T, T> {
            val activityWeakReference = WeakReference(context)
            val progressBar = MaterialDialog.Builder(activityWeakReference.get()!!)
                    .progress(true, 100, true)
                    .progressNumberFormat("%1d/%2d")
//                    .backgroundColor(ContextCompat.getColor(context, R.color.yellow_300))
                    .content("$loadText...")
                    .build()
            progressBar.show()
            return ObservableTransformer { upstream ->
                upstream.doOnEach {
                    //progressBar.show() //显示时会慢一点出来
                }.doOnTerminate {
                    progressBar.dismiss()
                }.doOnSubscribe {
//                    progressBar.dismiss()
                }
            }
        }*/
    }
}