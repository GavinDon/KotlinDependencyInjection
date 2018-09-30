package com.gavin.kotlindependencyinjection.ui

import android.os.Bundle
import android.util.Log
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.gavin.kotlindependencyinjection.R
import com.gavin.kotlindependencyinjection.SubjectCat
import com.gavin.kotlindependencyinjection.base.BaseActivity
import com.gavin.kotlindependencyinjection.mvp.contact.MainContact
import com.gavin.kotlindependencyinjection.mvp.presenter.MainPresenter
import com.gavin.kotlindependencyinjection.proxy.ISubject
import com.gavin.kotlindependencyinjection.proxy.ProxyHandler
import com.gavin.kotlindependencyinjection.proxy.RealSubject
import com.gavin.kotlindependencyinjection.proxy.SubjectProxy
import kotlinx.android.synthetic.main.test.*
import org.kodein.di.generic.instance
import java.lang.reflect.Proxy
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity(), MainContact.View {

    override fun update(o: Observable?, arg: Any?) {
        Log.i("hello", arg.toString())
    }


    private val mPresenter: MainPresenter by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        lifecycle.addObserver(mPresenter)
        mPresenter.attachView(this)
        testTv.setOnClickListener {
            mPresenter.showData()
            val request = PeriodicWorkRequest.Builder(Worker::class.java, 3, TimeUnit.SECONDS).build()
            WorkManager.getInstance().enqueue(request)
        }

        observerPattern()

        proxyPattern()


    }

    /**
     * 代理模式
     */
    private fun proxyPattern() {
        val subject = SubjectProxy(RealSubject())
        val handler = Proxy.newProxyInstance(RealSubject::class.java.classLoader,RealSubject::class.java.interfaces, ProxyHandler(subject)) as ISubject
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


}
