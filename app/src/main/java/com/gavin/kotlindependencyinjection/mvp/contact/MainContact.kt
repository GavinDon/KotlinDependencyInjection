package com.gavin.kotlindependencyinjection.mvp.contact

import com.gavin.kotlindependencyinjection.mvp.MvpCompanion

/**
 * description:
 * Created by liNan on 2018/9/19 16:47

 */
interface MainContact {

    interface View : MvpCompanion.MvpView

    interface Presenter : MvpCompanion.MvpPresenter<View> {
        fun showData()
    }

}