package com.gavin.kotlindependencyinjection.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * description:动态代理类 需实现InvocationHandler接口
 * 调用处理器，我们可以在这里实现我们需要的任务，当运行时代理类调用任何方法都会回调invoke()方法。
 * Created by liNan on 2018/9/30 9:58

 */
class ProxyHandler(subject: ISubject) : InvocationHandler {
    private val mSubject = subject

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        val result = method?.invoke(mSubject)
        return result
    }
}