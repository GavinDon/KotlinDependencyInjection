package com.gavin.kotlindependencyinjection.network

import android.text.TextUtils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * description:
 * Created by liNan on 2018/9/26 10:14

 */
class RetrofitManage {

    private lateinit var baseUrl: String


    companion object {
        //retrofitManage实例
        fun getInstance() = Holder.instance

    }


    /**
     * 使用kotlin object类实现单例模式
     */
    private object Holder {
        val instance = RetrofitManage()
    }

    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    /**
     * 设置baseUrl
     */
    fun setBaseUrl(url: String): RetrofitManage {
        if (TextUtils.isEmpty(url)) {
            throw KotlinNullPointerException("url不能为空")
        } else {
            return this
        }
    }


}