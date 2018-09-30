package com.gavin.kotlindependencyinjection.ui

import android.util.Log
import androidx.work.Worker

/**
 * description:
 * Created by liNan on 2018/9/28 17:11

 */
class Worker : Worker() {

    override fun doWork(): WorkerResult {
        Log.i("worker", "msg")
        return WorkerResult.SUCCESS
    }
}