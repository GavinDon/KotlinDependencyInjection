package com.gavin.kotlindependencyinjection.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gavin.kotlindependencyinjection.base.BaseViewModel
import com.gavin.kotlindependencyinjection.base.Resource

/**
 * description:像mvp中的presenter
 * 管理着view与model
 * Created by liNan on 2018/10/15 10:25

 */
class TestViewMode: BaseViewModel() {

    private lateinit var pswLiveData: MutableLiveData<Resource<String>>

    // Create a LiveData with a String
    val currentName: MutableLiveData<Resource<String>> by lazy {
        MutableLiveData<Resource<String>>()
    }
    fun getPsw(): LiveData<Resource<String>> {
        pswLiveData = MutableLiveData()
        return pswLiveData
    }


}