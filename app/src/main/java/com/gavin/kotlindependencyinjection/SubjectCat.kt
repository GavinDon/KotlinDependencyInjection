package com.gavin.kotlindependencyinjection

import java.util.*

/**
 * description:
 * Created by liNan on 2018/9/29 16:29

 */
class SubjectCat: Observable() {

    fun setData(){
        setChanged()
        notifyObservers("发生改变了")
    }

}