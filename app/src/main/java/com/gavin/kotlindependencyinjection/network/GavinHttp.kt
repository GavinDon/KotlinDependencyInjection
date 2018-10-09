package com.gavin.kotlindependencyinjection.network

import com.gavin.kotlindependencyinjection.network.callback.SimpleCallback
import com.gavin.kotlindependencyinjection.network.callback.SubscriberCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * description:
 * Created by liNan on 2018/9/26 14:34

 */
class GavinHttp {

    companion object {
        private val mRetrofit = RetrofitManage.getInstance()
                .setBaseUrl("")
                .getRetrofit()
        private val apiService = mRetrofit.create(ApiService::class.java)
        fun get() {

        }
    }

    fun test() {
        apiService.get("", hashMapOf())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(SubscriberCallback(object : SimpleCallback<String> {
                    override fun success(t: String) {
                    }

                }))
    }


}