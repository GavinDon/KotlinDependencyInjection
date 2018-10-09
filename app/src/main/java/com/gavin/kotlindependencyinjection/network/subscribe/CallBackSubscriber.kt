package com.gavin.kotlindependencyinjection.network.subscribe

import com.gavin.kotlindependencyinjection.network.callback.ICallback

/**
 * description:
 * Created by liNan on 2018/10/8 16:17

 */
class CallBackSubscriber<T>(val mCallBack:ICallback<T>): BaseSubscriber<T>() {

    override fun onComplete() {
        super.onComplete()
    }

    override fun onNext(t: T) {
        super.onNext(t)
        mCallBack.success(t)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
    }
}