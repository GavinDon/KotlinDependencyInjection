package com.gavin.kotlindependencyinjection.mvp

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

/**
 * description: 为了在activity or fragment destroy时 释放绑定的presenter
 * LifecycleObserver Lifecycle观察者
 * Created by liNan on 2018/9/19 16:13

 */
interface IPresenter : LifecycleObserver {

    /**
     * 释放presenter
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroyP() {
        this to null
        println("destroyP================")
    }

}