package com.gavin.kotlindependencyinjection.base

import android.app.Application
import com.gavin.kotlindependencyinjection.utils.main
import com.github.kittinunf.fuel.core.FuelManager
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

/**
 * description:
 * Created by liNan on 2018/9/17 11:00

 */
class MyApplication : Application(), KodeinAware {

    //首次检索时将创建的真实kodein对象
    override val kodein = Kodein.lazy {
        import(androidModule(this@MyApplication))
//        bind<TestC>() with singleton {
//            TestC()
//        }
        import(main)

    }

    override fun onCreate() {
        super.onCreate()
        FuelManager.instance.basePath= "http://www.wanandroid.com/"

    }



}