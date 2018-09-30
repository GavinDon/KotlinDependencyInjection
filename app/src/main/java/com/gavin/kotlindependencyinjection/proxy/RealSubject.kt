package com.gavin.kotlindependencyinjection.proxy

import android.util.Log

/**
 * description: 委托类，该类真正实现了buyTicket
 * Created by liNan on 2018/9/30 9:40

 */
class RealSubject:ISubject {
    override fun buyTicket() {
        Log.i("proxyPattern","开始买票了")
    }
}