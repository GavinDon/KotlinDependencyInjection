package com.gavin.kotlindependencyinjection.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

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