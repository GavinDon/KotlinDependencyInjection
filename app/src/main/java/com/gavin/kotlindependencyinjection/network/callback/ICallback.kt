package com.gavin.kotlindependencyinjection.network.callback

/**
 * description:
 * Created by liNan on 2018/10/8 15:28

 */
interface ICallback<T> {
    fun success(t: T)
    fun fail(msg: String)
}