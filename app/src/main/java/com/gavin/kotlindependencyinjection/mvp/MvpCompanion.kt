package com.gavin.kotlindependencyinjection.mvp

/**
 * description:
 * Created by liNan on 2018/9/19 16:41

 */
interface MvpCompanion {

    interface MvpView

    interface MvpPresenter<in V>:IPresenter {
        fun attachView(view: V)
    }


}