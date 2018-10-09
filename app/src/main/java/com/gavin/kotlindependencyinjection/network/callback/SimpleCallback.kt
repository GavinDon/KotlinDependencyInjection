package com.gavin.kotlindependencyinjection.network.callback

/**
 * description:
 * Created by liNan on 2018/10/8 15:31

 */
interface SimpleCallback<T> : ICallback<T> {
    override fun fail(msg: String) {
    }
}