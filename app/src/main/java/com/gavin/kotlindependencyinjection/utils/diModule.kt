package com.gavin.kotlindependencyinjection.utils

import com.gavin.kotlindependencyinjection.mvp.presenter.MainPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

/**
 * description:bind-> Singleton  Factory Multiton Provider
 *
 * Created by liNan on 2018/9/17 17:41

 */
val main = Kodein.Module("main"){
//    bind<TestC>() with singleton {
//        TestC()
//    }
    bind<MainPresenter>() with instance(MainPresenter())
}