package com.gavin.kotlindependencyinjection.base

import android.app.Application
import android.content.Context
import android.os.Environment
import com.allenliu.versionchecklib.v2.AllenVersionChecker
import com.allenliu.versionchecklib.v2.builder.UIData
import com.gavin.kotlindependencyinjection.utils.main
import com.gavin.kotlindependencyinjection.utils.responseInterceptor
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.interceptors.cUrlLoggingRequestInterceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

/**
 * description:
 * Created by liNan on 2018/9/17 11:00

 */
class MyApplication : Application(), KodeinAware {
    companion object {
        lateinit var appContext: Context
    }

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
        FuelManager.instance.apply {
            basePath = "http://www.wanandroid.com/"
            addRequestInterceptor(cUrlLoggingRequestInterceptor())
            addResponseInterceptor(responseInterceptor())
        }

        appContext = this
        //app 强制更新
        val uiData = UIData.create().setTitle("高铁在线")
                .setContent("修改一些bug\n修改一些bug\n修改一些bug")
                .setDownloadUrl("http://app-global.pgyer.com/3455d03f18b32c3b548d7802aa61057c.apk?attname=app-debug.apk&sign=e605d796bc0e1fffcbc49df3697e8f41&t=5bd818eb")
        val downloadBuilder = AllenVersionChecker
                .getInstance()
                .downloadOnly(uiData)
        downloadBuilder.apply {
            isSilentDownload = false
            apkName = "高铁在线"
            downloadAPKPath = "${Environment.getExternalStorageDirectory()}/HighSpeedOnLine/"
        }.setForceUpdateListener { }
                .executeMission(this)

    }


}