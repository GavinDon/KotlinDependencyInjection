package com.gavin.kotlindependencyinjection.ui

import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.gavin.kotlindependencyinjection.R
import com.gavin.kotlindependencyinjection.SubjectCat
import com.gavin.kotlindependencyinjection.base.BaseActivity
import com.gavin.kotlindependencyinjection.bean.HomeRespBean
import com.gavin.kotlindependencyinjection.fuel.FuelApi
import com.gavin.kotlindependencyinjection.mvp.contact.MainContact
import com.gavin.kotlindependencyinjection.mvp.presenter.MainPresenter
import com.gavin.kotlindependencyinjection.network.RxScheduler
import com.gavin.kotlindependencyinjection.proxy.ISubject
import com.gavin.kotlindependencyinjection.proxy.ProxyHandler
import com.gavin.kotlindependencyinjection.proxy.RealSubject
import com.gavin.kotlindependencyinjection.proxy.SubjectProxy
import com.github.kittinunf.fuel.httpDownload
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.rx.rx_bytes
import io.reactivex.disposables.CompositeDisposable
import org.kodein.di.generic.instance
import java.io.File
import java.lang.reflect.Proxy
import java.util.*

class MainActivity : BaseActivity(), MainContact.View {
    //    创建一个空的复合disposable类 来管理订阅
    private val compositeDisposable = CompositeDisposable()

    override fun update(o: Observable?, arg: Any?) {
        Log.i("hello", arg.toString())
    }


    private val mPresenter: MainPresenter by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(mPresenter)
        mPresenter.attachView(this)
//        animation_view.setOnClickListener {
//            mPresenter.showData()
//            val request = PeriodicWorkRequest.Builder(Worker::class.java, 3, TimeUnit.SECONDS).build()
//            WorkManager.getInstance().enqueue(request)
//        }

        observerPattern()

        proxyPattern()

        httpFuel()


    }

    private fun httpFuel() {

        val a1 = FuelApi.HOME.httpGet()
        a1.responseObject(HomeRespBean.Deserializer()) { request, response, result ->
            Log.i("fuel", result.get().data.datas!![0].chapterName)
            response.headers
        }

        val disposable = "https://www.lottiefiles.com/download/2861".httpDownload().destination { response, url ->
            val dir = Environment.getExternalStorageDirectory().path.plus("/kotlin")
            val tempFile = File(dir)
            if (!tempFile.exists()) {
                tempFile.mkdirs()
            }
            File(tempFile.path, "lottie.json")
        }.progress { readBytes, totalBytes ->
            val progress = readBytes.toFloat() / totalBytes.toFloat()
            Log.i("fuel", "$progress")
        }.rx_bytes().compose(RxScheduler.applySingle())
                .compose(RxScheduler.applyDialog(this))
                .subscribe { result, t2 ->
                    result.fold(success = {
                    }, failure = {})
                }
        compositeDisposable.add(disposable)
    }

    /**
     * 代理模式
     */
    private fun proxyPattern() {
        val subject = SubjectProxy(RealSubject())
        val handler = Proxy.newProxyInstance(RealSubject::class.java.classLoader, RealSubject::class.java.interfaces, ProxyHandler(subject)) as ISubject
        handler.buyTicket()
//        val realSubject = RealSubject()
//        SubjectProxy(realSubject).buyTicket()

    }

    /**
     * android包下的观察者模式使用
     */
    private fun observerPattern() {
        val sub = SubjectCat()
        sub.addObserver(this)
        sub.setData()
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()

    }

}
