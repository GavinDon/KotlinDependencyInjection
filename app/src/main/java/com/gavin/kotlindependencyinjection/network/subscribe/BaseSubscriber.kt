package com.gavin.kotlindependencyinjection.network.subscribe

import io.reactivex.observers.DisposableObserver

/**
 * description:
 * Created by liNan on 2018/10/8 15:56

 */
abstract class BaseSubscriber<T> : DisposableObserver<T>() {


    override fun onComplete() {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }
}