package com.gavin.kotlindependencyinjection.network

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


}